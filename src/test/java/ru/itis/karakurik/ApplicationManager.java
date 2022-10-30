package ru.itis.karakurik;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.itis.karakurik.helper.TeletypeHelperBase;
import ru.itis.karakurik.helper.LoginHelper;
import ru.itis.karakurik.helper.NavigationHelper;
import ru.itis.karakurik.helper.PostHelper;

import java.time.Duration;

public class ApplicationManager {
    public static String BASE_URL = "https://teletype.in/";
    public static final Duration TIMEOUT = Duration.ofSeconds(3);
    private static final String DRIVER_PROPERTY = "webdriver.edge.driver";
    private static final String DRIVER_PATH = "src\\main\\resources\\msedgedriver.exe";
    private final WebDriver driver;
    private final StringBuffer verificationErrors;

    private final TeletypeHelperBase helperBase;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final PostHelper postHelper;

    public ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        verificationErrors = new StringBuffer();

        helperBase = new TeletypeHelperBase(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);
    }

    public void close() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!verificationErrorString.equals("")) {
            Assert.fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public TeletypeHelperBase getHelperBase() {
        return helperBase;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }
}
