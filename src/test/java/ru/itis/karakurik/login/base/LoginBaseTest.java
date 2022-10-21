package ru.itis.karakurik.login.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.karakurik.base.TestBase;
import ru.itis.karakurik.dto.LoginDto;

public class LoginBaseTest extends TestBase {

    protected LoginDto loginDto;

    protected void loginBase() throws Exception {
        prepareLoginForm();
        fillLoginForm();
        Thread.sleep(1000);
        clickLogin();
    }

    protected void prepareLoginForm() throws Exception {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.className("login__header_title")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();
    }

    protected void fillLoginForm() {
        driver.findElement(By.name("email")).sendKeys(loginDto.getEmail());
        driver.findElement(By.name("password")).sendKeys(loginDto.getPassword());
    }

    private void clickLogin() {
        driver.findElement(By.className("login__form"))
                .findElement(By.className("m_type_filled"))
                .click();
    }

    public static boolean isLoggedIn(WebDriver driver) {
        try {
            driver.findElement(By.linkText("Войти"));
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
