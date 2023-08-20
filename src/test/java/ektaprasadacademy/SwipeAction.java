package ektaprasadacademy;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SwipeAction extends BaseTest {
    @Test
    public void swipeAction() throws MalformedURLException, InterruptedException {
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
        Assert.assertEquals(androidDriver.findElement(By.xpath("(//android.widget.ImageView[1])")).getAttribute("focusable"),"true");
        swipe(androidDriver.findElement(By.xpath("(//android.widget.ImageView[1])")),"left");
        Assert.assertEquals(androidDriver.findElement(By.xpath("(//android.widget.ImageView[1])")).getAttribute("focusable"),"false");

    }
}
