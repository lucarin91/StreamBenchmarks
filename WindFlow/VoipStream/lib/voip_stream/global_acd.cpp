#include "constants.hpp"
#include "global_acd.hpp"
#include "util/log.hpp"

namespace voip_stream {

GlobalACD::GlobalACD()
    : avg_call_duration_(ACD_DECAY_FACTOR)
{}

void GlobalACD::operator ()(const Dispatcher::Tuple &tuple, FilterTuple &result, wf::RuntimeContext &rc)
{
    DEBUG_LOG("global_acd::tuple " << tuple);

    avg_call_duration_.add(tuple.cdr.call_duration);

    result.ts = tuple.ts;
    result.source = SOURCE_GlobalACD;
    result.rate = avg_call_duration_.get_average();
    result.cdr = tuple.cdr;
}

}
