package ru.itis.karakurik.login;

import org.junit.Test;
import ru.itis.karakurik.base.TestBase;

public class LoginTest extends TestBase {
    @Test
    public void login() throws Exception {
        loginBase();
        Thread.sleep(5000);
    }
}
