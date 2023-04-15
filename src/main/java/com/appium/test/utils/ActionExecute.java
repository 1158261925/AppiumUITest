package com.appium.test.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionExecute {
    private ConvertMapValue convertMapValue;
    private AndroidDriver driver;

    public ActionExecute(ConvertMapValue convertMapValue,AndroidDriver driver){
        this.convertMapValue = convertMapValue;
        this.driver = driver;
    }

    public void executeSingleCase(){
        // 等待元素出现，出现异常记录到日志中
        WaitTimeForSingleEle.waitForElement(convertMapValue.getWaitTime(),convertMapValue.getByObject(),convertMapValue.getDes(), driver);
        ActionRecordEnum opr = convertMapValue.getOpr();
        // 找到元素后，进行click或send操作
        switch (opr){
            case CLICK:
                driver.findElement(convertMapValue.getByObject()).click();
                break;
            case SENDKEYS:
                driver.findElement(convertMapValue.getByObject()).sendKeys(opr.getDes());
                break;
            default:
                LogUtil.error("标题为： "+convertMapValue.getDes()+" 的用例opr行未找到click或send动作");
        }

    }
}
