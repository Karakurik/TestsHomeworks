package ru.itis.karakurik.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.itis.karakurik.ApplicationManager;

public class TeletypeHelperBase {
    protected ApplicationManager applicationManager;
    protected WebDriver driver;

    public TeletypeHelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void sleep(long seconds) throws InterruptedException {
        Thread.sleep(1000 * seconds);
    }

    protected void sendEscapeKey() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }
}
