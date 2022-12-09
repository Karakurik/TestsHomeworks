package ru.itis.karakurik.helper;

import org.openqa.selenium.By;
import ru.itis.karakurik.ApplicationManager;
import ru.itis.karakurik.model.LoginModel;

public class LoginHelper extends TeletypeHelperBase {
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(LoginModel loginModel) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();

        sleep(3);

        driver.findElement(By.name("email")).sendKeys(loginModel.getEmail());
        driver.findElement(By.name("password")).sendKeys(loginModel.getPassword());
        driver.findElement(By.className("login__form"))
                .findElement(By.className("m_type_filled"))
                .click();

        sleep(3);
    }

    public void logout() throws InterruptedException {
        driver.findElement(By.className("menu__account")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[5]/div[2]")).click();
        sleep(3);
    }

    public boolean isAuthorized() {
        return isElementPresent(By.className("menu__account"));
    }

    public String getAuthorizedUserPath() {
        if (!isAuthorized()) return null;

        String path = driver.findElement(By.xpath("//li[@id='l_pr']/a")).getAttribute("href");
        path = path.substring(path.lastIndexOf('/'));

        return path;
    }

    public String getAuthorizedUserNickName() {
        if (!isAuthorized()) return null;

        return driver.findElement(By.className("menu__account_name")).getText();
    }
}
