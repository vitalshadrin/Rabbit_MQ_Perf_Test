package rabbit_perf;

import com.rabbitmq.perf.PerfTest;

import static config.ArgsGenerator.getArgs;
import static config.ArgsGenerator.setReport;
import static config.RabbitConfigs.PERF_TEST;


public class RabbitPerfTest {

    public static void main(String[] args) throws Exception {
        PerfTest.main(args.length == 0 ? getArgs(PERF_TEST) : setReport(args));
    }
}
