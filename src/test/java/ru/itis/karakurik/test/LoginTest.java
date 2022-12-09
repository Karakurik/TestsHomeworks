package ru.itis.karakurik.test;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TeletypeTestBase {

    @Test
    public void login() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(LOGIN_MODEL);
        applicationManager.getHelperBase().sleep(5);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());
        Assert.assertEquals(LOGIN_MODEL.getNickName(), applicationManager.getLoginHelper().getAuthorizedUserNickName());

        applicationManager.getLoginHelper().logout();
    }
}
