package ru.itis.karakurik.test;

import org.junit.Before;
import ru.itis.karakurik.ApplicationManager;

public class TeletypeTestBase {
    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws InterruptedException {
        applicationManager = ApplicationManager.getInstance();
    }
}
