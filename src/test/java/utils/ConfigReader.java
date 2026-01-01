package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {    private final String expectedUrl = "https://ecommerce.tealiumdemo.com/customer/account/index/";

    private static Properties prop;

    public static String getProperty(String key) {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(key);
    }
}



