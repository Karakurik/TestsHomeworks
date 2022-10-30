package ru.itis.karakurik.helper;

import org.openqa.selenium.By;
import ru.itis.karakurik.ApplicationManager;

public class NavigationHelper extends TeletypeHelperBase {
    private final String baseUrl;
    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openMainPage() throws InterruptedException {
        driver.get(baseUrl);
        sleep(3);
    }

    public void openLoginPage() throws InterruptedException {
        openMainPage();
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.className("login__header_title")).click();
        sleep(3);
    }

    public void openNewPostPage() throws InterruptedException {
        driver.findElement(By.className("newArticleMenu")).click();
        sleep(3);
    }

    public void openBlogPage() throws InterruptedException {
        driver.findElement(By.className("menu__account")).click();
        driver.findElement(By.className("accountPopup__blog")).click();
    }
}
