package tests;

import base.BaseTest;
import org.testng.annotations.*;
import pages.GamePage;

public class GamePlayTest extends BaseTest {
    GamePage gamePage;

    @BeforeMethod
    public void startApp() throws Exception {
        setup();
        gamePage = new GamePage(driver);
    }

    @Test
    public void testTargetHitAndScoreUpdate() {
        gamePage.tapStartButton();
        assert gamePage.isScoreVisible();
        gamePage.tapTarget();
    }

    @AfterMethod
    public void closeApp() {
        tearDown();
    }
}
