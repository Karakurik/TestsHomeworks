package ru.itis.karakurik.login;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.itis.karakurik.dto.LoginDto;

import java.util.concurrent.TimeUnit;

public class LoginTestSimple {

    private static LoginDto loginDto;
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeClass
    public static void setUp() {
        loginDto = new LoginDto("insafanas@mail.ru", "insaf_password");
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        baseUrl = "https://teletype.in/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Before
    public void open() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test
    public void loginSuccess() throws Exception {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.className("login__header_title")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();

        driver.findElement(By.name("email")).sendKeys(loginDto.getEmail());
        driver.findElement(By.name("password")).sendKeys(loginDto.getPassword());

        Thread.sleep(1000);
        driver.findElement(By.className("login__form"))
                .findElement(By.className("m_type_filled"))
                .click();
        Thread.sleep(20000);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
