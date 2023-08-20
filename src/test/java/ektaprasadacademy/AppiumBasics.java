package ektaprasadacademy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics extends BaseTest{
    @Test
    public void AppiumTest() throws MalformedURLException, InterruptedException {

        //adb shell
        //dumpsys window displays | grep -E "mCurrentFocus"

        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        androidDriver.startActivity(activity);
//        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        androidDriver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landScape = new DeviceRotation(0,0,90);
        androidDriver.rotate(landScape);
        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        Assert.assertEquals(androidDriver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
        androidDriver.setClipboardText("EKTA");
        androidDriver.findElement(By.id("android:id/edit")).sendKeys(androidDriver.getClipboardText());
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(5000);
        androidDriver.findElement(By.id("android:id/button1")).click();
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));


    }

}
