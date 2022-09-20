package utility;

import java.io.IOException;
import java.util.Properties;

public enum ApplicationProperties {

    INSTANCE;

    private final Properties properties;

    ApplicationProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getTitle() {
        return properties.getProperty("title");
    }


}
