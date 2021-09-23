package config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;
    private static PropertiesReader instance = null;
    private static String propertyName;

    public PropertiesReader(String propertyName) {
        PropertiesReader.propertyName = propertyName;
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PropertiesReader.propertyName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader(propertyName);
        }
        return instance;
    }

    public Properties getProperties() {
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
