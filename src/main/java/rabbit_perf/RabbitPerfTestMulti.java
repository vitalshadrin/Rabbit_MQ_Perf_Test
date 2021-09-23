package rabbit_perf;

import com.rabbitmq.perf.PerfTestMulti;

import static config.ArgsGenerator.getArgs;
import static config.RabbitConfigs.PERF_TEST_MULTI;

public class RabbitPerfTestMulti {

    public static void main(String[] args) throws Exception {
        PerfTestMulti.main(args.length == 0 ? getArgs(PERF_TEST_MULTI) :  getArgs(PERF_TEST_MULTI, args[0]));
    }
}
