package ru.itis.karakurik.post;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.itis.karakurik.base.TestBase;
import ru.itis.karakurik.dto.PostDto;
import ru.itis.karakurik.login.LoginTest;

public class NewPostTest extends TestBase {

    @Before
    public void setUp() {
        postDto = new PostDto("Привет! Это заголовок", "тута fish text");
    }

    @Test
    public void addNewTest() throws Exception {
        loginIfNotYet();
        openNewPostPage();
        addTitleAndText();
        Thread.sleep(5000);
        clickPublish();
        Thread.sleep(5000);
        clickApplyPublish();
        Thread.sleep(10000);
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
