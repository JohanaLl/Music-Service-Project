package com.music.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFactory {

    private static final Properties properties;
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyFactory.class);
    private static final String CONFIG_FILE = "config.properties";

    static {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        var props = new Properties();
        try (var inputStream = PropertyFactory.class.getClassLoader()
                .getResourceAsStream(CONFIG_FILE)){
            if (inputStream instanceof InputStream is) {
                props.load(is);
            }
        } catch (Exception e) {
            LOGGER.error("Error loading properties: {}", e.getMessage(), e);
        }
        return props;
    }

    public static Properties getProperties(){
        return properties;
    }
}
