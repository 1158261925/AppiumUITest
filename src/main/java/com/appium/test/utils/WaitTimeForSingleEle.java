package com.appium.test.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/*
* 等待设置的时间后指定元素是否出现，若出现继续执行后续操作，否则记录失败信息到日志中，并打印失败的栈信息
* */
public class WaitTimeForSingleEle {

    public static void waitForElement(int waitTime, By by, String des, AndroidDriver driver){
        // 打印当前操作
        LogUtil.info(des);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            LogUtil.error("当前元素没有找到，用例描述："+des);
            Assert.fail("用例失败");
            e.printStackTrace();
        }

    }

}
