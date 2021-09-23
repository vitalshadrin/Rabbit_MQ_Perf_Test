package config;

import java.util.ArrayList;
import java.util.List;

import static config.PropertiesReader.getInstance;
import static report.ReportTemplate.getResultDirectory;

public class ArgsGenerator {

    public static String[] getArgs(RabbitConfigs rabbitConfigs, String specName) {
        switch (rabbitConfigs) {
            case PERF_TEST:
                return getPerfConfigs();
            case PERF_TEST_MULTI:
                return getPerfMultiConfigs(specName);
        }
        return null;
    }

    public static String[] getArgs(RabbitConfigs rabbitConfigs) {
        new PropertiesReader("config/" + rabbitConfigs.getConfig());
        switch (rabbitConfigs) {
            case PERF_TEST:
                return getPerfConfigs();
            case PERF_TEST_MULTI:
                return getPerfMultiConfigs(getInstance().getProperties().getProperty("spec"));
        }
        return null;
    }

    private static String[] getPerfConfigs() {
        getInstance().updateProperty("output-file", getResultDirectory("results.csv"));
        return getInstance().getProperties()
                .keySet()
                .stream()
                .map(key -> "-" + key + "=" + getInstance().getProperties().get(key))
                .toArray(String[]::new);
    }

    private static String[] getPerfMultiConfigs(String specName) {
        List<String> listArgs = new ArrayList<String>() {{
            add("src/main/resources/spec/" + specName);
            add(getResultDirectory("spec_results.js"));
        }};
        return listArgs.toArray(new String[0]);
    }
}
