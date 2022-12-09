package ru.itis.karakurik.test.test4;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.karakurik.model.PostModel;
import ru.itis.karakurik.test.TeletypeTestBase;

public class DeleteLastPostTest extends TeletypeTestBase {

    @Test
    public void deleteLastPost() throws Exception {
        applicationManager.getNavigationHelper().openBlogPage();
        PostModel lastPost = applicationManager.getPostHelper().getLastPost();
        applicationManager.getPostHelper().deleteLastPost();
        applicationManager.getNavigationHelper().openBlogPage();
        PostModel fakeLastPost = applicationManager.getPostHelper().getLastPost();
        Assert.assertTrue(
                fakeLastPost == null ||
                        !lastPost.getTitle().equals(fakeLastPost.getTitle()) ||
                        !lastPost.getContent().equals(fakeLastPost.getContent())
        );
    }
}
