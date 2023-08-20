package ektaprasadacademy;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DragAndDrop extends BaseTest
{
    @Test
    public void dragAndDropAction() throws MalformedURLException, InterruptedException {
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement webElement = androidDriver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragDropAction(webElement,802,715);
        Thread.sleep(10000);

    }
}
