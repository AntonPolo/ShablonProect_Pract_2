package ru.Anton.support.core.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RequestSourceFactory {
    public static RequestSource create() {
        String type = loadConfig();
        switch (type) {
            case "db": return new DatabaseRequestSource();
            case "file": return new FileRequestSource();
            case "web": return new WebRequestSource();
            default: throw new IllegalArgumentException("Unknown source type: " + type);
        }
    }

    private static String loadConfig() {
        try (InputStream input = RequestSourceFactory.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("dataSourceType", "db");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }
}
