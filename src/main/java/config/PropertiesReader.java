package config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static report.ReportTemplate.getResultDirectory;

public class PropertiesReader {
    private Properties properties;
    private String propertyName;

    public PropertiesReader(String propertyName) {
        this.propertyName = propertyName;
    }

    public Properties getProperties() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.propertyName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties updateProperty(String propertyName, String key, String value){
        try {
            FileOutputStream out = new FileOutputStream(propertyName);
            properties.setProperty(key, value);
            properties.store(out, null);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
