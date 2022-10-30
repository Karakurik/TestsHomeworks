package ru.itis.karakurik.test;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TeletypeTestBase {

    @Test
    public void login() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(loginDto);
        applicationManager.getHelperBase().sleep(5);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());
        Assert.assertEquals(loginDto.getNickName(), applicationManager.getLoginHelper().getAuthorizedUserNickName());

        applicationManager.getLoginHelper().logout();
    }
}
