package ru.itis.karakurik.helper;

import org.openqa.selenium.By;
import ru.itis.karakurik.ApplicationManager;
import ru.itis.karakurik.model.PostModel;

public class PostHelper extends TeletypeHelperBase {
    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createPost(PostModel post) throws InterruptedException {
        driver.findElement(By.className("editor")).sendKeys(post.getTitle());
        driver.findElement(By.className("editorPage__text")).sendKeys(post.getContent());
        driver.findElement(By.className("publishButton")).click();
        applicationManager.getHelperBase().sleep(3);
        driver.findElement(By.className("editorPublisher__submit")).click();
    }

    public PostModel getLastPost() throws InterruptedException {
        try {
            driver.findElement(By.className("blog__articles_list")).findElement(By.className("lnk")).click();
        } catch (Exception e) {
            return null;
        }
        applicationManager.getHelperBase().sleep(3);
        String title = driver.findElement(By.className("article__header_title")).getText();
        String content = driver.findElement(By.className("article__content")).getText();
        return new PostModel(title, content);
    }

    public void deleteLastPost() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[3]/div[1]/a")).click();
        applicationManager.getHelperBase().sleep(3);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[3]/div/button")).click();
        sendEnterKey();
    }
}
