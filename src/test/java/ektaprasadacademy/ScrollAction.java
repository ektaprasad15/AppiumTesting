package ektaprasadacademy;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollAction extends BaseTest
{
    @Test
    public void scrollTo() throws MalformedURLException, InterruptedException {
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
    //    scrollToEndAction();
        scrollToText("WebView");

    }
}
