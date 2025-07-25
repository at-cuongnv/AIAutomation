package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        try (FileInputStream input = new FileInputStream(CONFIG_PATH)) {
            properties.load(input);
            logger.info("Loaded configuration from {}");
        } catch (IOException e) {
            logger.error("Failed to load configuration: {}");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url", "http://localhost:3000");
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "false"));
    }

    public static String getScreenshotPath() {
        return properties.getProperty("screenshot.path", "reports/screenshots");
    }

    public static String getTestDataPath() {
        return properties.getProperty("testdata.path", "src/test/resources/testdata");
    }
} 