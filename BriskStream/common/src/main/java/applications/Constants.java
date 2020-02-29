package applications;

import util.OsUtils;

/**
 * HPI machine
 * L1d cache:             32K
 * L1i cache:             32K
 * L2 cache:              256K
 * L3 cache:              25600K
 */
public interface Constants {

    String STAT_Path = System.getProperty("user.home")
//            + (OsUtils.isMac() ? "" : OsUtils.OS_wrapper("Documents"))
            + OsUtils.OS_wrapper("briskstream") + OsUtils.OS_wrapper("STAT");
    String MAP_Path = System.getProperty("user.home")
//            + (OsUtils.isMac() ? "" : OsUtils.OS_wrapper("Documents"))
            + OsUtils.OS_wrapper("briskstream") + OsUtils.OS_wrapper("MAP");
    String System_Plan_Path = System.getProperty("user.home")
//            + (OsUtils.isMac() ? "" : OsUtils.OS_wrapper("Documents"))
            + OsUtils.OS_wrapper("briskstream") + OsUtils.OS_wrapper("PLAN");
    String Event_Path = System.getProperty("user.home")
//            + (OsUtils.isMac() ? "" : OsUtils.OS_wrapper("Documents"))
            + OsUtils.OS_wrapper("briskstream") + OsUtils.OS_wrapper("EVENT");


    char sinkType = 's';
    char spoutType = 'p';
    char boltType = 'b';
    char virtualType = 'v';
    String DEFAULT_STREAM_ID = "default";
    String Marker_STREAM_ID = "marker";
    int DEFAULT_Socket_ID = 1;

    interface EVENTS {

        String UNHALTED_CORE_CYCLES = "UNHALTED_CORE_CYCLES";
        String INSTRUCTION_RETIRED = "INSTRUCTION_RETIRED";
        String INSTRUCTIONS_RETIRED = "INSTRUCTIONS_RETIRED";
        String UNHALTED_REFERENCE_CYCLES = "UNHALTED_REFERENCE_CYCLES";
        String LLC_REFERENCES = "LLC_REFERENCES";
        String LAST_LEVEL_CACHE_REFERENCES = "LAST_LEVEL_CACHE_REFERENCES";
        String LLC_MISSES = "LLC_MISSES";
        String LAST_LEVEL_CACHE_MISSES = "LAST_LEVEL_CACHE_MISSES";
        String BRANCH_INSTRUCTIONS_RETIRED = "BRANCH_INSTRUCTIONS_RETIRED";
        String ARITH = "ARITH";
        String BACLEAR = "BACLEAR";
        String BACLEAR_FORCE_IQ = "BACLEAR_FORCE_IQ";
        String BOGUS_BR = "BOGUS_BR";
        String BPU_CLEARS = "BPU_CLEARS";
        String BPU_MISSED_CALL_RET = "BPU_MISSED_CALL_RET";
        String BR_INST_DECODED = "BR_INST_DECODED";
        String BR_INST_EXEC = "BR_INST_EXEC";
        String BR_INST_RETIRED = "BR_INST_RETIRED";
        String BR_MISP_EXEC = "BR_MISP_EXEC";
        String BR_MISP_RETIRED = "BR_MISP_RETIRED";
        String CACHE_LOCK_CYCLES = "CACHE_LOCK_CYCLES";
        String CPU_CLK_UNHALTED = "CPU_CLK_UNHALTED";
        String DTLB_LOAD_MISSES = "DTLB_LOAD_MISSES";
        String DTLB_MISSES = "DTLB_MISSES";
        String EPT = "EPT";
        String ES_REG_RENAMES = "ES_REG_RENAMES";
        String FP_ASSIST = "FP_ASSIST";
        String FP_COMP_OPS_EXE = "FP_COMP_OPS_EXE";
        String FP_MMX_TRANS = "FP_MMX_TRANS";
        String IFU_IVC = "IFU_IVC";
        String ILD_STALL = "ILD_STALL";
        String INST_DECODED = "INST_DECODED";
        String INST_QUEUE_WRITES = "INST_QUEUE_WRITES";
        String INST_QUEUE_WRITE_CYCLES = "INST_QUEUE_WRITE_CYCLES";
        String INST_RETIRED = "INST_RETIRED";
        String IO_TRANSACTIONS = "IO_TRANSACTIONS";
        String ITLB_FLUSH = "ITLB_FLUSH";
        String ITLB_MISSES = "ITLB_MISSES";
        String ITLB_MISS_RETIRED = "ITLB_MISS_RETIRED";
        String L1D = "L1D";
        String L1D_ALL_REF = "L1D_ALL_REF";
        String L1D_CACHE_LD = "L1D_CACHE_LD";
        String L1D_CACHE_LOCK = "L1D_CACHE_LOCK";
        String L1D_CACHE_LOCK_FB_HIT = "L1D_CACHE_LOCK_FB_HIT";
        String L1D_CACHE_PREFETCH_LOCK_FB_HIT = "L1D_CACHE_PREFETCH_LOCK_FB_HIT";
        String L1D_CACHE_ST = "L1D_CACHE_ST";
        String L1D_PREFETCH = "L1D_PREFETCH";
        String L1D_WB_L2 = "L1D_WB_L2";
        String L1I = "L1I";
        String L1I_OPPORTUNISTIC_HITS = "L1I_OPPORTUNISTIC_HITS";
        String L2_DATA_RQSTS = "L2_DATA_RQSTS";
        String L2_HW_PREFETCH = "L2_HW_PREFETCH";
        String L2_LINES_IN = "L2_LINES_IN";
        String L2_LINES_OUT = "L2_LINES_OUT";
        String L2_RQSTS = "L2_RQSTS";
        String L2_TRANSACTIONS = "L2_TRANSACTIONS";
        String L2_WRITE = "L2_WRITE";
        String LARGE_ITLB = "LARGE_ITLB";
        String LOAD_DISPATCH = "LOAD_DISPATCH";
        String LOAD_HIT_PRE = "LOAD_HIT_PRE";
        String LONGEST_LAT_CACHE = "LONGEST_LAT_CACHE";
        String LSD = "LSD";
        String MACHINE_CLEARS = "MACHINE_CLEARS";
        String MACRO_INSTS = "MACRO_INSTS";
        String MEMORY_DISAMBIGUATION = "MEMORY_DISAMBIGUATION";
        String MEM_INST_RETIRED = "MEM_INST_RETIRED";
        String MEM_LOAD_RETIRED = "MEM_LOAD_RETIRED";
        String MEM_STORE_RETIRED = "MEM_STORE_RETIRED";
        String MEM_UNCORE_RETIRED = "MEM_UNCORE_RETIRED";
        String OFFCORE_REQUESTS = "OFFCORE_REQUESTS";
        String OFFCORE_REQUESTS_SQ_FULL = "OFFCORE_REQUESTS_SQ_FULL";
        String PARTIAL_ADDRESS_ALIAS = "PARTIAL_ADDRESS_ALIAS";
        String PIC_ACCESSES = "PIC_ACCESSES";
        String RAT_STALLS = "RAT_STALLS";
        String RESOURCE_STALLS = "RESOURCE_STALLS";
        String SEG_RENAME_STALLS = "SEG_RENAME_STALLS";
        String SEGMENT_REG_LOADS = "SEGMENT_REG_LOADS";
        String SIMD_INT_128 = "SIMD_INT_128";
        String SIMD_INT_64 = "SIMD_INT_64";
        String SNOOP_RESPONSE = "SNOOP_RESPONSE";
        String SQ_FULL_STALL_CYCLES = "SQ_FULL_STALL_CYCLES";
        String SQ_MISC = "SQ_MISC";
        String SSE_MEM_EXEC = "SSE_MEM_EXEC";
        String SSEX_UOPS_RETIRED = "SSEX_UOPS_RETIRED";
        String STORE_BLOCKS = "STORE_BLOCKS";
        String TWO_UOP_INSTS_DECODED = "TWO_UOP_INSTS_DECODED";
        String UOPS_DECODED_DEC0 = "UOPS_DECODED_DEC0";
        String UOPS_DECODED = "UOPS_DECODED";
        String UOPS_EXECUTED = "UOPS_EXECUTED";
        String UOPS_ISSUED = "UOPS_ISSUED";
        String UOPS_RETIRED = "UOPS_RETIRED";
        String UOP_UNFUSION = "UOP_UNFUSION";
        String OFFCORE_RESPONSE_0 = "OFFCORE_RESPONSE_0";

        String PERF_COUNT_HW_CPU_CYCLES = "PERF_COUNT_HW_CPU_CYCLES";

        String CYCLES = "CYCLES";

        String CPU_CYCLES = "CPU-CYCLES";

        String PERF_COUNT_HW_INSTRUCTIONS = "PERF_COUNT_HW_INSTRUCTIONS";

        String INSTRUCTIONS = "INSTRUCTIONS";

        String PERF_COUNT_HW_CACHE_REFERENCES = "PERF_COUNT_HW_CACHE_REFERENCES";

        String CACHE_REFERENCES = "CACHE-REFERENCES";

        String PERF_COUNT_HW_CACHE_MISSES = "PERF_COUNT_HW_CACHE_MISSES";

        String CACHE_MISSES = "CACHE-MISSES";

        String PERF_COUNT_HW_BRANCH_INSTRUCTIONS = "PERF_COUNT_HW_BRANCH_INSTRUCTIONS";

        String BRANCH_INSTRUCTIONS = "BRANCH-INSTRUCTIONS";

        String BRANCHES = "BRANCHES";

        String PERF_COUNT_HW_BRANCH_MISSES = "PERF_COUNT_HW_BRANCH_MISSES";

        String BRANCH_MISSES = "BRANCH-MISSES";

        String PERF_COUNT_HW_BUS_CYCLES = "PERF_COUNT_HW_BUS_CYCLES";

        String BUS_CYCLES = "BUS-CYCLES";

        String PERF_COUNT_HW_STALLED_CYCLES_FRONTEND = "PERF_COUNT_HW_STALLED_CYCLES_FRONTEND";

        String STALLED_CYCLES_FRONTEND = "STALLED-CYCLES-FRONTEND";

        String IDLE_CYCLES_FRONTEND = "IDLE-CYCLES-FRONTEND";

        String PERF_COUNT_HW_STALLED_CYCLES_BACKEND = "PERF_COUNT_HW_STALLED_CYCLES_BACKEND";

        String STALLED_CYCLES_BACKEND = "STALLED-CYCLES-BACKEND";

        String IDLE_CYCLES_BACKEND = "IDLE-CYCLES-BACKEND";

        String PERF_COUNT_HW_REF_CPU_CYCLES = "PERF_COUNT_HW_REF_CPU_CYCLES";

        String REF_CYCLES = "REF-CYCLES";

        String PERF_COUNT_SW_CPU_CLOCK = "PERF_COUNT_SW_CPU_CLOCK";

        String CPU_CLOCK = "CPU-CLOCK";

        String PERF_COUNT_SW_TASK_CLOCK = "PERF_COUNT_SW_TASK_CLOCK";

        String TASK_CLOCK = "TASK-CLOCK";

        String PERF_COUNT_SW_PAGE_FAULTS = "PERF_COUNT_SW_PAGE_FAULTS";

        String PAGE_FAULTS = "PAGE-FAULTS";

        String FAULTS = "FAULTS";

        String PERF_COUNT_SW_CONTEXT_SWITCHES = "PERF_COUNT_SW_CONTEXT_SWITCHES";

        String CONTEXT_SWITCHES = "CONTEXT-SWITCHES";

        String CS = "CS";

        String PERF_COUNT_SW_CPU_MIGRATIONS = "PERF_COUNT_SW_CPU_MIGRATIONS";

        String CPU_MIGRATIONS = "CPU-MIGRATIONS";

        String MIGRATIONS = "MIGRATIONS";

        String PERF_COUNT_SW_PAGE_FAULTS_MIN = "PERF_COUNT_SW_PAGE_FAULTS_MIN";

        String MINOR_FAULTS = "MINOR-FAULTS";

        String PERF_COUNT_SW_PAGE_FAULTS_MAJ = "PERF_COUNT_SW_PAGE_FAULTS_MAJ";

        String MAJOR_FAULTS = "MAJOR-FAULTS";

        String PERF_COUNT_HW_CACHE_L1D = "PERF_COUNT_HW_CACHE_L1D";

        String L1_DCACHE_LOADS = "L1-DCACHE-LOADS";

        String L1_DCACHE_LOAD_MISSES = "L1-DCACHE-LOAD-MISSES";

        String L1_DCACHE_STORES = "L1-DCACHE-STORES";

        String L1_DCACHE_STORE_MISSES = "L1-DCACHE-STORE-MISSES";

        String L1_DCACHE_PREFETCHES = "L1-DCACHE-PREFETCHES";

        String L1_DCACHE_PREFETCH_MISSES = "L1-DCACHE-PREFETCH-MISSES";

        String PERF_COUNT_HW_CACHE_L1I = "PERF_COUNT_HW_CACHE_L1I";

        String L1_ICACHE_LOADS = "L1-ICACHE-LOADS";

        String L1_ICACHE_LOAD_MISSES = "L1-ICACHE-LOAD-MISSES";

        String L1_ICACHE_PREFETCHES = "L1-ICACHE-PREFETCHES";

        String L1_ICACHE_PREFETCH_MISSES = "L1-ICACHE-PREFETCH-MISSES";

        String PERF_COUNT_HW_CACHE_LL = "PERF_COUNT_HW_CACHE_LL";

        String LLC_LOADS = "LLC-LOADS";

        String LLC_LOAD_MISSES = "LLC-LOAD-MISSES";

        String LLC_STORES = "LLC-STORES";

        String LLC_STORE_MISSES = "LLC-STORE-MISSES";

        String LLC_PREFETCHES = "LLC-PREFETCHES";

        String LLC_PREFETCH_MISSES = "LLC-PREFETCH-MISSES";

        String PERF_COUNT_HW_CACHE_DTLB = "PERF_COUNT_HW_CACHE_DTLB";

        String DTLB_LOADS = "DTLB-LOADS";

        String DTLB_STORES = "DTLB-STORES";

        String DTLB_STORE_MISSES = "DTLB-STORE-MISSES";

        String DTLB_PREFETCHES = "DTLB-PREFETCHES";

        String DTLB_PREFETCH_MISSES = "DTLB-PREFETCH-MISSES";

        String PERF_COUNT_HW_CACHE_ITLB = "PERF_COUNT_HW_CACHE_ITLB";

        String ITLB_LOADS = "ITLB-LOADS";

        String ITLB_LOAD_MISSES = "ITLB-LOAD-MISSES";

        String PERF_COUNT_HW_CACHE_BPU = "PERF_COUNT_HW_CACHE_BPU";

        String BRANCH_LOADS = "BRANCH-LOADS";

        String BRANCH_LOAD_MISSES = "BRANCH-LOAD-MISSES";

        String PERF_COUNT_HW_CACHE_NODE = "PERF_COUNT_HW_CACHE_NODE";

        String NODE_LOADS = "NODE-LOADS";

        String NODE_LOAD_MISSES = "NODE-LOAD-MISSES";

        String NODE_STORES = "NODE-STORES";

        String NODE_STORE_MISSES = "NODE-STORE-MISSES";

        String NODE_PREFETCHES = "NODE-PREFETCHES";

        String NODE_PREFETCH_MISSES = "NODE-PREFETCH-MISSES";


    }


}
