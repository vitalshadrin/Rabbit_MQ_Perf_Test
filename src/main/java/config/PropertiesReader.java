package config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;
    private final String propertyName;

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

    public void updateProperty(String key, String value) {
        try (FileOutputStream out = new FileOutputStream("src/main/resources/" + propertyName)) {
            properties.setProperty(key, value);
            properties.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
