package com.appium.test.testCase;

import com.appium.test.utils.ActionExecute;
import com.appium.test.utils.ConvertMapValue;
import com.appium.test.utils.ResolveFileToList;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/*
* 单个场景测试，单个场景对应一个properties文件中(例如：UIElementTest.properties文件)的所有case
* 如果有多个文件，则创建多个该类的实例对象，传入对应文件的名称
* */
public class SingleSceneCase {
    private List<Properties> fileToList;
    private AndroidDriver driver;

    public SingleSceneCase(AndroidDriver driver,String fileName) throws IOException {
        this.fileToList = new ResolveFileToList(fileName).getFileToList();
        this.driver = driver;

    }

    // 执行每个场景的所有的case
    public void executeSceneCase(){
        for (Properties properties : fileToList){
            ActionExecute actionExecute = new ActionExecute(new ConvertMapValue(properties, fileToList), driver);
            actionExecute.executeSingleCase();
        }

    }
}
