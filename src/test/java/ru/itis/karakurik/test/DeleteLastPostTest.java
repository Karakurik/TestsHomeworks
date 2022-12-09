package ru.itis.karakurik.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.karakurik.model.PostModel;

public class DeleteLastPostTest extends TeletypeTestBase {

    @Test
    public void deleteLastPost() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(LOGIN_MODEL);
        applicationManager.getHelperBase().sleep(3);
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
        applicationManager.getLoginHelper().logout();
    }
}
