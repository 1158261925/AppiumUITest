package com.appium.test;

import com.appium.test.testCase.SingleSceneCase;
import com.appium.test.utils.ActionRecordEnum;
import com.appium.test.utils.InitDriver;
import com.appium.test.utils.OrderedProperties;
import com.appium.test.utils.ResolveFileToList;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class MainWindow {

    public static void main(String[] args) throws IOException, InterruptedException {

        AndroidDriver driver = InitDriver.initWithResetData("emulator-5554");
        Thread.sleep(10000);
        SingleSceneCase singleSceneCase = new SingleSceneCase(driver, "UIElementTest.properties");
        singleSceneCase.executeSceneCase();
    }
}
