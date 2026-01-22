package com.rishi.pw.utils;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHandler {

	static {
		File logDir = new File("logs");
		if (!logDir.exists()) {
			logDir.mkdirs();
		}
		System.setProperty("logfile.name", "logs/logfile_" + HelperMethods.getTimestamp("dd-MM-yyyy-HH-mm") + ".log");
	}
	
	private static final Logger LOGGER = LogManager.getLogger(LoggerHandler.class);

	public static void info(String message) {
		LOGGER.info(message);
	}

	public static void trace(String message) {
		LOGGER.trace(message);
	}

	public static void warn(String message) {
		LOGGER.warn(message);
	}

	public static void fatal(String message) {
		LOGGER.fatal(message);
	}

	public static void error(String message) {
		LOGGER.error(message);
	}

	public static void debug(String message) {
		LOGGER.debug(message);
	}
}
