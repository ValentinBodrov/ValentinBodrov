package hw6.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum UserPropertiesSingleton {

    INSTANCE;

    private Properties userProperties;

    public void setUserProperties() {
        userProperties = new Properties();
        try {
            userProperties.load(new FileInputStream(
                    "src/main/resources/user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getUserProperties() {
        return userProperties;
    }

}
