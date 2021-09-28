package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import spec.Spec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static config.PropertiesReader.getInstance;
import static report.ReportTemplate.getResultDirectory;

public class ArgsGenerator {

    public static String[] getArgs(RabbitConfigs rabbitConfigs, String specName, String specArgs) {
        switch (rabbitConfigs) {
            case PERF_TEST:
                return getPerfConfigs();
            case PERF_TEST_MULTI:
                return getPerfMultiConfigs(specName, specArgs);
        }
        return null;
    }

    public static String[] getArgs(RabbitConfigs rabbitConfigs) {
        new PropertiesReader("config/" + rabbitConfigs.getConfig());
        switch (rabbitConfigs) {
            case PERF_TEST:
                return getPerfConfigs();
            case PERF_TEST_MULTI:
                return getPerfMultiConfigs(getInstance().getProperties().getProperty("spec"), null);
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

    public static String[] setReport(String[] args) {
        return new ArrayList<String>() {{
            addAll(Arrays.asList(args));
            add("-output-file=" + getResultDirectory("results.csv"));
        }}.toArray(new String[0]);
    }

    private static String[] getPerfMultiConfigs(String specName, String specArgs) {
        List<String> listArgs = new ArrayList<String>() {{
            add(specArgs == null ? "src/main/resources/spec/" + specName : updatedSpec(specName, specArgs));
            add(getResultDirectory(specName));
        }};
        return listArgs.toArray(new String[0]);
    }

    private static String updatedSpec(String specName, String specArgs) {
        String spec = "src/main/resources/spec/" + specName;
        ObjectMapper objectMapper = new ObjectMapper();
        String specContent;
        Spec[] data;
        Map<String, String> specMap = new HashMap<>();
        try {
            specContent = new String(Files.readAllBytes(Paths.get(spec)), StandardCharsets.UTF_8);
            data = objectMapper.readValue(specContent, Spec[].class);
            Arrays.asList(specArgs.split(",")).forEach(specData ->
                    specMap.put(specData.split("=")[0].trim(), specData.split("=")[1].trim())
            );
            specMap.keySet().forEach(key -> {
                switch (key) {
                    case "name":
                        data[0].setName(specMap.get(key));
                        break;
                    case "uri":
                        data[0].setUri(specMap.get(key));
                        break;
                    case "type":
                        data[0].setType(specMap.get(key));
                        break;
                    case "time-limit":
                        data[0].getParams().get(0).setTimeLimit(Integer.parseInt(specMap.get(key)));
                        break;
                    case "queue-names":
                        data[0].getParams().get(0).setQueueNames(Arrays.asList(specMap.get(key).split(";")));
                        break;
                    case "auto-delete":
                        data[0].getParams().get(0).setAutoDelete(Boolean.parseBoolean(specMap.get(key)));
                        break;
                    case "x-single-active-consumer":
                        data[0].getParams().get(0).getQueueArguments().setXSingleActiveConsumer(Boolean.parseBoolean(specMap.get(key)));
                        break;
                }
            });
            Files.write(Paths.get(spec), objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return spec;
    }
}
