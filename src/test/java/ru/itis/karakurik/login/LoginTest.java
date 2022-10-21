package ru.itis.karakurik.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.itis.karakurik.dto.LoginDto;
import ru.itis.karakurik.login.base.LoginBaseTest;

public class LoginTest extends LoginBaseTest {

  @Before
  public void setUp() {
    loginDto = new LoginDto("insafanas@mail.ru", "insaf_password");
  }

  @Test
  public void login() throws Exception {
    loginBase();
    Thread.sleep(20000);
  }

  @After
  public void tearDown() {
    closeDriver();
  }
}
