package com.appium.test.utils;

import java.io.*;
import java.util.*;

public class ResolveFileToList {

    private Properties properties = new OrderedProperties();

    // 传入文件名，并将文件中的数据按文件顺序以key-value的形式保存到properties对象中
    public ResolveFileToList(String fileName) throws IOException {
        String filePath = System.getProperties().getProperty("user.dir") + "/src/main/java/com/appium/test/elementsFile/" + fileName;
        Reader reader = new FileReader(filePath);
        properties.load(reader);
    }

    // 获取properties文件中的用例单元，每个单元以key-value的形式保存到HashMap中，返回List<Map>对象，map按序排列
    public List<Properties> getFileToList() {
        List<Properties> list = new ArrayList();
        int n = 0;
        Set<Object> keySet = properties.keySet();
        Properties pro = new OrderedProperties();
        for (Object o : keySet) {
            if (n != 0 && n % 3 == 0) {
                list.add(pro);
                pro = new OrderedProperties();
            }
            pro.put(o, properties.get(o));
            n++;
            if (n==keySet.size()){
                list.add(pro);
            }
        }
        return list;
    }

}
