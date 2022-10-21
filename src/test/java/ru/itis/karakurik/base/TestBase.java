package ru.itis.karakurik.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected String baseUrl;

    protected TestBase() {
        initDriver();
        openHomePage();
        resizeScreen();
        startDriver();
    }

    private void initDriver() {
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    private void openHomePage() {
        baseUrl = "https://teletype.in/";
        driver.get(baseUrl);
    }

    private void resizeScreen() {
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        driver.close();
    }

    private void startDriver() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
}
