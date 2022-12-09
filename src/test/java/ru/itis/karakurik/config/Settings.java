package ru.itis.karakurik.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Settings {
    public static String file = "src/test/resources/Settings.xml";

    private static final Properties properties;
    private static String baseUrl;
    private static String login;
    private static String password;
    private static String nickname;

    static {
        try (FileInputStream fis = new FileInputStream(file)) {
            properties = new Properties();
            properties.loadFromXML(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = properties.getProperty("BaseUrl");
        }
        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            login = properties.getProperty("Login");
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = properties.getProperty("Password");
        }
        return password;
    }

    public static String getNickname() {
        if (nickname == null) {
            nickname = properties.getProperty("NickName");
        }
        return nickname;
    }
}
