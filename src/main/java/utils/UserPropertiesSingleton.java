package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserPropertiesSingleton extends Properties {

    protected static UserPropertiesSingleton instance;

    public static UserPropertiesSingleton getInstance() {
        if (instance == null) {
            instance = new UserPropertiesSingleton();
            try {
                instance.load(new FileInputStream(
                        "src/main/resources/jdiuser.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
