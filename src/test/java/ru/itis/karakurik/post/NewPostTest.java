package ru.itis.karakurik.post;

import org.junit.Test;
import ru.itis.karakurik.base.TestBase;

public class NewPostTest extends TestBase {
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
}
