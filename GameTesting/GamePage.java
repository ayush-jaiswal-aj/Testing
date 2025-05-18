package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GamePage {
    AndroidDriver<MobileElement> driver;

    public GamePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void tapStartButton() {
        driver.findElementByAccessibilityId("startButton").click();
    }

    public boolean isScoreVisible() {
        return driver.findElementByAccessibilityId("scoreText").isDisplayed();
    }

    public void tapTarget() {
        driver.findElementByXPath("//android.view.View[contains(@content-desc, 'target')]").click();
    }
}
