package WordCount;

import Util.Log;
import Util.MetricGroup;
import org.slf4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.LoggerFactory;
import org.apache.storm.Config;
import Constants.BaseConstants;
import Constants.BaseConstants.*;
import Util.config.Configuration;
import org.apache.storm.tuple.Fields;
import Constants.WordCountConstants;
import org.apache.storm.LocalCluster;
import Constants.WordCountConstants.*;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;

/** 
 *  @author  Alessandra Fais
 *  @version July 2019
 *  
 *  The topology entry class.
 */ 
public class WordCount {
    private static final Logger LOG = Log.get(WordCount.class);

    // main method
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals(BaseConstants.HELP)) {
            String alert = "Parameters: --rate <value> --sampling <value> --parallelism <nSource nSplitter nCounter nSink>\n";
            LOG.error(alert);
        }
        else {
            // load configuration
            Config conf = new Config();
            try {
                String cfg = WordCountConstants.DEFAULT_PROPERTIES;
                Properties p = loadProperties(cfg);
                conf = Configuration.fromProperties(p);
                LOG.debug("Loaded configuration file {}", cfg);
            }
            catch (IOException e) {
                LOG.error("Unable to load configuration file", e);
                throw new RuntimeException("Unable to load configuration file", e);
            }
            // parse command line arguments
            boolean isCorrect = true;
            int gen_rate = -1;
            int sampling = 1;
            int source_par_deg = 1;
            int splitter_par_deg = 1;
            int counter_par_deg = 1;
            int sink_par_deg = 1;
            if (args.length == 9) {
                if (!args[0].equals("--rate")) {
                    isCorrect = false;
                }
                else {
                    try {
                        gen_rate = Integer.parseInt(args[1]);
                    }
                    catch (NumberFormatException e) {
                        isCorrect = false;
                    }
                }
                if (!args[2].equals("--sampling"))
                    isCorrect = false;
                else {
                    try {
                        sampling = Integer.parseInt(args[3]);
                    }
                    catch (NumberFormatException e) {
                        isCorrect = false;
                    }
                }
                if (!args[4].equals("--parallelism"))
                    isCorrect = false;
                else {
                    try {
                        source_par_deg = Integer.parseInt(args[5]);
                        splitter_par_deg = Integer.parseInt(args[6]);
                        counter_par_deg = Integer.parseInt(args[7]);
                        sink_par_deg = Integer.parseInt(args[8]);
                    }
                    catch (NumberFormatException e) {
                        isCorrect = false;
                    }
                }
            }
            else {
                LOG.error("Error in parsing the input arguments");
                System.exit(1);
            }
            if (!isCorrect) {
               LOG.error("Error in parsing the input arguments");
               System.exit(1);
            }
            String file_path = ((Configuration) conf).getString(Conf.SPOUT_PATH);
            String topology_name = WordCountConstants.DEFAULT_TOPO_NAME;
            long runTimeSec = ((Configuration) conf).getInt(Conf.RUNTIME);
            // prepare the topology
            TopologyBuilder builder = new TopologyBuilder();
            builder.setSpout(Component.SPOUT,
                    new FileParserSpout(file_path, gen_rate, source_par_deg, runTimeSec), source_par_deg);

            builder.setBolt(Component.SPLITTER,
                    new SplitterBolt(splitter_par_deg), splitter_par_deg)
                    .shuffleGrouping(Component.SPOUT);

            builder.setBolt(Component.COUNTER,
                    new CounterBolt(counter_par_deg), counter_par_deg)
                    .fieldsGrouping(Component.SPLITTER, new Fields(Field.WORD));

            builder.setBolt(Component.SINK,
                    new ConsoleSink(sink_par_deg, gen_rate, sampling), sink_par_deg)
                    .shuffleGrouping(Component.COUNTER);

            // build the topology
            StormTopology topology = builder.createTopology();

            // additional configuration parameters of Storm
            long buffer_size = ((Configuration) conf).getInt(Conf.BUFFER_SIZE);
            conf.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, buffer_size);
            if (gen_rate != 0) {
                // optimize latency
                conf.put(Config.TOPOLOGY_PRODUCER_BATCH_SIZE, 1);
                conf.put(Config.TOPOLOGY_TRANSFER_BATCH_SIZE, 1);
            }

            // print app info
            LOG.info("Executing WordCount with parameters:\n" +
                     "  * rate: " + ((gen_rate == 0) ? "full_speed" : gen_rate) + " tuples/second\n" +
                     "  * sampling: " + sampling + "\n" +
                     "  * source: " + source_par_deg + "\n" +
                     "  * splitter: " + splitter_par_deg + "\n" +
                     "  * counter: " + counter_par_deg + "\n" +
                     "  * sink: " + sink_par_deg + "\n" +
                     "  * topology: source -> splitter -> counter -> sink");

            // run the topology
            try {
                LOG.info("Submitting topology");
                LocalCluster cluster = new LocalCluster();
                cluster.submitTopology(topology_name, conf, topology);
                LOG.info("Waiting for topology termination...");
                long polling_time = ((Configuration) conf).getInt(Conf.POLLING_TIME);
                while (cluster.getNimbus().getClusterInfo().get_topologies_size() > 0) {
                    Thread.sleep(polling_time);
                }
                // kill cluster
                LOG.info("...Shutting down cluster");
                cluster.shutdown();
                LOG.info("Exiting");
                // dump the metrics
                LOG.info("Dumping metrics");
                MetricGroup.dumpAll();
            }
            catch (Exception e) {
                LOG.error(e.getMessage());
            }
            System.exit(0);
        }
    }

    /**
     * Load configuration properties for the application.
     * @param filename the name of the properties file
     * @return the persistent set of properties loaded from the file
     * @throws IOException
     */
    private static Properties loadProperties(String filename) throws IOException {
        Properties properties = new Properties();
        InputStream is = WordCount.class.getResourceAsStream(filename);
        if (is != null) {
            properties.load(is);
            is.close();
        }
        //LOG.info("[main] Properties loaded: {}.", properties.toString());
        return properties;
    }
}
