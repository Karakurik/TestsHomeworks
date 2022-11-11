package ru.itis.karakurik.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.karakurik.dto.PostDto;

public class DeleteLastPostTest extends TeletypeTestBase {

    @Test
    public void deleteLastPost() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(loginDto);
        applicationManager.getHelperBase().sleep(3);
        applicationManager.getNavigationHelper().openBlogPage();

        PostDto lastPost = applicationManager.getPostHelper().getLastPost();
        applicationManager.getPostHelper().deleteLastPost();
        applicationManager.getNavigationHelper().openBlogPage();
        PostDto fakeLastPost = applicationManager.getPostHelper().getLastPost();
        Assert.assertTrue(
                fakeLastPost == null ||
                        !lastPost.getTitle().equals(fakeLastPost.getTitle()) ||
                        !lastPost.getContent().equals(fakeLastPost.getContent())
        );
        applicationManager.getLoginHelper().logout();
    }
}
