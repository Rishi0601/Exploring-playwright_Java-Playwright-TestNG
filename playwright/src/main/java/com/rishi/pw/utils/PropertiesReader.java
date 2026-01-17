package com.rishi.pw.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

	private static final Properties properties = new Properties();

	static {
		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Properties getProperty() {
		return properties;
	}
}
