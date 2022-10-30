package ru.itis.karakurik.test;

import org.junit.After;
import org.junit.Before;
import ru.itis.karakurik.ApplicationManager;

public class TeletypeTestBase {
    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = new ApplicationManager();
    }

    @After
    public void tearDown() {
        applicationManager.close();
    }
}
