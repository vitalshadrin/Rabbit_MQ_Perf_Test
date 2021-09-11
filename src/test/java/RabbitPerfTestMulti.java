import com.rabbitmq.perf.PerfTestMulti;

import static config.ArgsGenerator.getArgs;

public class RabbitPerfTestMulti {

    public static void main(String[] args) throws Exception {
        PerfTestMulti.main(args.length == 0 ? getArgs("perfTestMulti.properties") : args);
    }
}
