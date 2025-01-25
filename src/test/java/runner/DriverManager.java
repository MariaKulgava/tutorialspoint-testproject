package runner;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestDataReaderUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverManager {

    private static Properties properties = TestDataReaderUtil.readProperties("/properties/config.properties");

    public static void setupDriver() {
        Configuration.browser = properties.getProperty("browser", "chrome");
        Configuration.browserSize = properties.getProperty("browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(properties.getProperty("timeout", "10000"));
        Configuration.baseUrl = properties.getProperty("baseUrl");

        switch (Configuration.browser.toLowerCase()) {
            case "chrome":
                setupChrome();
                break;
            case "firefox":
                setupFirefox();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + Configuration.browser);
        }
    }

    private static void setupChrome() {
        ChromeOptions options = new ChromeOptions();

        // Block ads, images, and pop-ups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.images", 2); // Disable image loading
        prefs.put("profile.managed_default_content_settings.popups", 2); // Disables pop-ups
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    private static void setupFirefox() {
        FirefoxOptions options = new FirefoxOptions();

        // Block images and pop-ups
        options.addPreference("permissions.default.image", 2); // 2 = Block images
        options.addPreference("dom.disable_open_during_load", true); // Disable popups

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        Configuration.browserCapabilities = capabilities;
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }
}
