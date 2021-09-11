package config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static report.ReportTemplate.getResultDirectory;

public class ArgsGenerator {
    public static String[] args;

    public static String[] getArgs(String propertyName) {
        if (args == null) {
            PropertiesReader propertiesReader = new PropertiesReader(propertyName);
            Properties properties = propertiesReader.getProperties();
            if (propertyName.contains("Multi")) {
                List<String> listArgs = new ArrayList<>();
                listArgs.add("src/test/resources/" + properties.getProperty("spec"));
                listArgs.add(getResultDirectory("spec_results.js"));
                args = listArgs.toArray(String[]::new);
            } else {
                propertiesReader.updateProperty(propertyName, "output-file", getResultDirectory("results.csv"));
                args = properties
                        .keySet()
                        .stream()
                        .map(key -> "-" + key + "=" + properties.get(key))
                        .toArray(String[]::new);
            }
        }
        return args;
    }
}
