package ru.itis.karakurik.helper;

import org.openqa.selenium.By;
import ru.itis.karakurik.ApplicationManager;
import ru.itis.karakurik.dto.LoginDto;

public class LoginHelper extends TeletypeHelperBase {
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(LoginDto loginDto) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();

        sleep(3);

        driver.findElement(By.name("email")).sendKeys(loginDto.getEmail());
        driver.findElement(By.name("password")).sendKeys(loginDto.getPassword());
        driver.findElement(By.className("login__form"))
                .findElement(By.className("m_type_filled"))
                .click();

        sleep(3);
    }
}
