package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Assistant {

    private Assistant(){}
        protected static final Properties properties = new Properties();

        public static String getConfigPropertiesValues(String projectName, String variable) {
            try {
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/" + projectName + "/config.properties");
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties.getProperty(variable);
        }




}
