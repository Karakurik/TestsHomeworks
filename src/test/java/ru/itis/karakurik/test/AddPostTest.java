package ru.itis.karakurik.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.karakurik.dto.PostDto;

public class AddPostTest extends TeletypeTestBase {

    @Test
    public void addPost() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(loginDto);
        applicationManager.getHelperBase().sleep(3);
        applicationManager.getNavigationHelper().openNewPostPage();
        applicationManager.getPostHelper().createPost(postDto);
        applicationManager.getNavigationHelper().openBlogPage();

        PostDto createdPost = applicationManager.getPostHelper().getLastPost();
        Assert.assertEquals(postDto.getTitle(), createdPost.getTitle());
        Assert.assertEquals(postDto.getContent(), createdPost.getContent());

        applicationManager.getLoginHelper().logout();
    }
}
