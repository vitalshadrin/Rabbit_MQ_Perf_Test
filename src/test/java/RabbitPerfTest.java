import com.rabbitmq.perf.PerfTest;

import static config.ArgsGenerator.getArgs;

public class RabbitPerfTest {

    public static void main(String[] args) throws Exception {
        PerfTest.main(args.length == 0 ? getArgs("perfTest.properties") : args);
    }
}
