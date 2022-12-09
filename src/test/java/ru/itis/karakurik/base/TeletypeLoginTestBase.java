package ru.itis.karakurik.base;

import org.junit.Before;
import ru.itis.karakurik.config.Settings;
import ru.itis.karakurik.model.UserModel;
import ru.itis.karakurik.test.TeletypeTestBase;

public class TeletypeLoginTestBase extends TeletypeTestBase {
    protected static final UserModel user = new UserModel(
            Settings.getLogin(),
            Settings.getPassword(),
            Settings.getNickname()
    );

    @Before
    public void setUp() throws InterruptedException {
        super.setUp();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(5);
    }
}
