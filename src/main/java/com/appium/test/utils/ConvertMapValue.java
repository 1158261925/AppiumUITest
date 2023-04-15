package com.appium.test.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConvertMapValue {

    private Properties properties = null;
    private List list = null;
    private String locator = null;
    private String opr = null;
    private String asserts = null;
    private List<Properties> listPro;
    private Properties propertiesNext = null;

    public ConvertMapValue(Properties properties, List<Properties> listPro) {
        this.properties = properties;
        this.listPro = listPro;
        list = new ArrayList(properties.keySet());
        locator = properties.get(list.get(0)).toString().trim();
        opr = properties.get(list.get(1)).toString().trim();
        asserts = properties.get(list.get(2)).toString().trim();

        // 当前Properties对象在list中的下标
        if (listPro.indexOf(properties) < (listPro.size() - 1)) {
            propertiesNext = listPro.get(listPro.indexOf(properties) + 1);
        }

    }


    public int getWaitTime() {

        String[] strArr = locator.split(":");
        return Integer.valueOf(strArr[0]);

    }

    // 如果当前Properties对象不是最后一个，则取下一个PropertiesNext对象的等待时间作为当前Properties操作后的断言时间
    // 如果当前Properties对象是最后一个,则当前Properties操作后的断言时间跟等待当前Properties出现的时间一致
    public int getNextWaitTime() {
        if (propertiesNext != null) {
            List list = new ArrayList(propertiesNext.keySet());
            String locator2 = propertiesNext.get(list.get(0)).toString().trim();
            String[] split = locator2.split(":");
            return Integer.valueOf(split[0]);
        }else {
            return getWaitTime();
        }

    }


    // 返回By对象
    public By getByObject() {
        String[] strArr = locator.split(":");
        // 获取定位类型：xpath、resourceid、className等
        String locatorType = strArr[1].split(">>")[0];
        // 获取定位元素唯一路径：如 //Android.Wget.Frame[@name="link3.html"]
        String locatorPath = strArr[1].split(">>")[1];
        System.out.println(locatorPath);
        switch (locatorType.toLowerCase()) {
            case "name":
                return By.name(locatorPath);
            case "id":
                return By.id(locatorPath);
            case "xpath":
                return By.xpath(locatorPath);
            case "classname":
                return By.className(locatorPath);
            case "tagname":
                return By.tagName(locatorPath);
            case "linktext":
                return By.linkText(locatorPath);
            case "partiallinktext":
                return By.partialLinkText(locatorPath);
            default:
                return null;
        }
    }

    // 如果当前Properties对象不是最后一个，则取下一个PropertiesNext对象的元素
    // 如果当前Properties对象是最后一个,返回null
    public By getNextByObject() {
        if (propertiesNext != null) {
            List list = new ArrayList(propertiesNext.keySet());
            String locator2 = propertiesNext.get(list.get(0)).toString().trim();
            String[] strArr = locator2.split(":");
            // 获取定位类型：xpath、resourceid、className等
            String locatorType = strArr[1].split(">>")[0];
            // 获取定位元素唯一路径：如 //Android.Wget.Frame[@name="link3.html"]
            String locatorPath = strArr[1].split(">>")[1];
            switch (locatorType.toLowerCase()) {
                case "name":
                    return By.name(locatorPath);
                case "id":
                    return By.id(locatorPath);
                case "xpath":
                    return By.xpath(locatorPath);
                case "classname":
                    return By.className(locatorPath);
                case "tagname":
                    return By.tagName(locatorPath);
                case "linktext":
                    return By.linkText(locatorPath);
                case "partiallinktext":
                    return By.partialLinkText(locatorPath);
                default:
                    return null;
            }
        }else {
            return null;
        }
    }

    // 返回用例描述对象
    public String getDes() {
        String[] strArr = locator.split(":");
        return strArr[2];
    }

    public ActionRecordEnum getOpr() {
        if (opr.toLowerCase().contains("send") && !opr.toLowerCase().contains("click")) {
            // 如果opr对应的value值只有send，则只执行输入数据操作（id为2）
            String sendMsg = opr.split("\\(")[1].split("\\)")[0];
            ActionRecordEnum actionRecordEnum = ActionRecordEnum.SENDKEYS;
            actionRecordEnum.setDes(sendMsg);
            return actionRecordEnum;

        } else if (!opr.toLowerCase().contains("send") && opr.toLowerCase().contains("click")) {
            // 如果opr对应的value值只有click，则只执行点击操作（id为1）
            return ActionRecordEnum.CLICK;
        } else {
            LogUtil.error("标题为：" + getDes() + "的用例对应的opr数据出现错误，请检查");
            return null;
        }

    }

    public String getAssert() {
        //获取第三行信息：asserts

        if (asserts == null || asserts.trim().isEmpty()) {
            System.out.println("断言对应行数据为空！");
            return null;
        } else {
            return asserts;
        }
    }
}
