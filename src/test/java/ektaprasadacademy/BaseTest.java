package ektaprasadacademy;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseTest
{
    public AndroidDriver androidDriver;
    public AppiumDriverLocalService appiumServiceBuilder;

    @BeforeClass
    public void startService() throws MalformedURLException {
//        appiumServiceBuilder = new AppiumServiceBuilder()
//                .withAppiumJS(new File("C:\\Users\\ektap\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).build();
//        appiumServiceBuilder.start();
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Test Device 1");
        uiAutomator2Options.setApp("C:\\Users\\ektap\\IdeaProjects\\AppiumTesting\\resources\\ApiDemos-debug.apk");
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),uiAutomator2Options);
        androidDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
    }

    public void longPressIcon(WebElement element)
    {
        ((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration",40000));
    }

    public void scrollToEndAction()
    {
        boolean canScrollMore;
        do {
            canScrollMore= (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left",100,
                            "top", 100,
                            "width", 100,
                            "height", 200,
                            "direction", "down",
                            "percent", 3.0));
        }while (canScrollMore);
    }
    public void scrollToText(String text)
    {
         androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }

    public void swipe(WebElement element, String direction)
    {
         ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
                        "direction", direction,
                        "percent", 0.75));
    }

    public void dragDropAction(WebElement element, int x , int y)
    {
        ((JavascriptExecutor) androidDriver).executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
                        "endX", x,
                        "endY", y));
    }

    @AfterClass
    public void tearDown()
    {
        androidDriver.quit();
//        appiumServiceBuilder.stop();

    }
}
