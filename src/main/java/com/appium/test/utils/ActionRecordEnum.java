package com.appium.test.utils;

public enum ActionRecordEnum {
    CLICK("1","remark"),
    SENDKEYS("2","remark");

    private final String id;
    private String des;


    ActionRecordEnum(String id,String des){
        this.id = id;
        this.des = des;
    }


    public String getId() {
        return id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
