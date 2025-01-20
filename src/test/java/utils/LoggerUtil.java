package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static final Logger log = LogManager.getLogger(LoggerUtil.class);

    public static void logInfo(String message) {
        log.info(message);
    }

    public static void logError(String message) {
        log.error(message);
    }

    public static void logDebug(String message) {
        log.debug(message);
    }
}
