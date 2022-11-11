package ru.itis.karakurik.test;

import org.junit.After;
import org.junit.Before;
import ru.itis.karakurik.ApplicationManager;
import ru.itis.karakurik.dto.LoginDto;
import ru.itis.karakurik.dto.PostDto;

public class TeletypeTestBase {
    protected static final LoginDto loginDto = new LoginDto("insafanas@mail.ru", "insaf_password", "@insaf_256");
    protected static final PostDto postDto = new PostDto("Привет! Это заголовок", "тута fish text");
    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
