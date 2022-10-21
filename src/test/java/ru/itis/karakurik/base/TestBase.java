package ru.itis.karakurik.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.itis.karakurik.dto.LoginDto;
import ru.itis.karakurik.dto.PostDto;
import ru.itis.karakurik.login.LoginTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    @Before
    public void setUp() {
        postDto = new PostDto("Привет! Это заголовок", "тута fish text");
        loginDto = new LoginDto("insafanas@mail.ru", "insaf_password");
    }

    @After
    public void tearDown() {
        closeDriver();
    }

    protected WebDriver driver;
    protected String baseUrl;

    protected PostDto postDto;
    protected LoginDto loginDto;

    protected TestBase() {
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        openHomePage();
        resizeScreen();
        startDriver();
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

    protected void openNewPostPage() {
        driver.findElement(By.className("newArticleMenu")).click();
    }

    protected void addTitleAndText() {
        driver.findElement(By.className("editor"))
                .sendKeys("А");
        driver.findElement(By.className("editorPage__text")).sendKeys(postDto.getText());
    }

    protected void clickPublish() throws Exception {
        driver.findElement(By.className("publishButton")).click();
    }

    protected void clickApplyPublish() {
        driver.findElement(By.className("editorPublisher__submit")).click();
    }

    protected void loginIfNotYet() throws Exception {
        if (!isLoggedIn(driver)) {
            driver.findElement(By.linkText("Войти")).click();
            driver.findElement(By.className("login__header_title")).click();
            Thread.sleep(1000);
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("password")).clear();

            driver.findElement(By.name("email")).sendKeys("insafanas@mail.ru");
            driver.findElement(By.name("password")).sendKeys("insaf_password");

            driver.findElement(By.className("login__form"))
                    .findElement(By.className("m_type_filled"))
                    .click();
        }
    }

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
