package ru.itis.karakurik.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class StringUtils {
    private static final Random random = new Random();

    public static String generateRandomText(int minLength, int maxLength) {
        return RandomStringUtils.randomAlphanumeric(random.nextInt(maxLength - minLength) + minLength);
    }

    public static String generateRandomEmail(int minLength, int maxLength) {
        return RandomStringUtils.randomAlphanumeric(random.nextInt(maxLength - minLength) + minLength) + "@mail.ru";
    }
}
