package ru.itis.karakurik.helper;

import org.openqa.selenium.By;
import ru.itis.karakurik.ApplicationManager;
import ru.itis.karakurik.dto.PostDto;

public class PostHelper extends TeletypeHelperBase {
    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createPost(PostDto post) throws InterruptedException {
        driver.findElement(By.className("editor")).sendKeys(post.getTitle());
        driver.findElement(By.className("editorPage__text")).sendKeys(post.getContent());
        driver.findElement(By.className("publishButton")).click();
        applicationManager.getHelperBase().sleep(3);
        driver.findElement(By.className("editorPublisher__submit")).click();
    }
}
