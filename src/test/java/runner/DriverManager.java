package runner;

import com.codeborne.selenide.Configuration;
import utils.TestDataReaderUtil;

import java.util.Properties;

public class DriverManager {
    private static Properties properties = TestDataReaderUtil.readProperties("/properties/config.properties");

    public static void setupDriver() {
        Configuration.browser = properties.getProperty("browser", "chrome");
        Configuration.browserSize = properties.getProperty("browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(properties.getProperty("timeout", "10000"));
        Configuration.baseUrl = properties.getProperty("baseUrl");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }
}