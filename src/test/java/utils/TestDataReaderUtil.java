package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import runner.DriverManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReaderUtil {

    public static Properties readProperties(String filePath) {
        Properties props = new Properties();
        try (InputStream input = DriverManager.class.getResourceAsStream(filePath)) {
            if (input != null) {
                props.load(input);
            } else {
                throw new RuntimeException("Configuration file not found: " + filePath);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
        return props;
    }

    public static <T> T readJsonData(String filePath, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data file", e);
        }
    }
}
