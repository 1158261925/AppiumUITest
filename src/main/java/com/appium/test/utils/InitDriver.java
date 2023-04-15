package com.appium.test.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InitDriver {

    // 每次打开都不重置数据
    public static AndroidDriver initWithResetData(String udid) throws MalformedURLException {
        DesiredCapabilities caps = getCommonCaps(udid);
        caps.setCapability(MobileCapabilityType.NO_RESET,true);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.luojilab.player");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.luojilab.business.welcome.SplashActivity");
        // caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.luojilab.business.welcome.SplashActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;

    }

    // 获取公共caps参数
    public static DesiredCapabilities getCommonCaps(String udid){
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability(MobileCapabilityType.UDID, udid);
        des.setCapability(MobileCapabilityType.DEVICE_NAME, "任意安卓设备");
        des.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        des.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        des.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
        des.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
        des.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        des.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        des.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        return des;
    }
}
