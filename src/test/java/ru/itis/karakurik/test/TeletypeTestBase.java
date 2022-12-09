package ru.itis.karakurik.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import ru.itis.karakurik.ApplicationManager;
import ru.itis.karakurik.model.LoginModel;

import java.util.Random;

public class TeletypeTestBase {
    protected static final LoginModel LOGIN_MODEL = new LoginModel("insafanas@mail.ru", "insaf_password", "@insaf_256");
    protected ApplicationManager applicationManager;
    private static final Random random = new Random();

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }

    public static String generateRandomText(int minLength, int maxLength) {
        return RandomStringUtils.randomAlphanumeric(random.nextInt(maxLength-minLength) + minLength);
    }
}
