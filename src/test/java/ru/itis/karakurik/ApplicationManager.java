package ru.itis.karakurik;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.itis.karakurik.config.Settings;
import ru.itis.karakurik.helper.TeletypeHelperBase;
import ru.itis.karakurik.helper.LoginHelper;
import ru.itis.karakurik.helper.NavigationHelper;
import ru.itis.karakurik.helper.PostHelper;
import ru.itis.karakurik.utils.DestructorUtil;

import java.time.Duration;

public class ApplicationManager {
    public static final String BASE_URL = Settings.getBaseUrl();
    public static final Duration TIMEOUT = Duration.ofSeconds(3);
    private static final String DRIVER_PROPERTY = "webdriver.edge.driver";
    private static final String DRIVER_PATH = "src\\main\\resources\\msedgedriver.exe";
    private final WebDriver driver;
    private final StringBuffer verificationErrors;
    private final JavascriptExecutor js;
    private final TeletypeHelperBase helperBase;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final PostHelper postHelper;
    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    public ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        js = (JavascriptExecutor) driver;
        verificationErrors = new StringBuffer();

        helperBase = new TeletypeHelperBase(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);

        DestructorUtil.addManagerDestructor(this);
    }

    public static ApplicationManager getInstance() {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
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
