package ru.itis.karakurik.test;

import org.junit.Test;
import ru.itis.karakurik.dto.LoginDto;
import ru.itis.karakurik.dto.PostDto;

public class LoginAndAddPostTest extends TeletypeTestBase {
    private static final LoginDto loginDto = new LoginDto("insafanas@mail.ru", "insaf_password");
    private static final PostDto postDto = new PostDto("Привет! Это заголовок", "тута fish text");

    @Test
    public void login() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(loginDto);
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    public void addPos() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(loginDto);
        applicationManager.getHelperBase().sleep(3);
        applicationManager.getNavigationHelper().openNewPostPage();
        applicationManager.getPostHelper().createPost(postDto);

        applicationManager.getHelperBase().sleep(10);
    }
}
