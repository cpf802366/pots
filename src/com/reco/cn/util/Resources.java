package com.reco.cn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cpf on 2018/4/25.
 */
public class Resources {
    public static String getValue(String Key) {
        Properties properties=new Properties();
        try {
            InputStream in =Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.properties");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value="";
        try {
            value =new String(properties.getProperty(Key).getBytes("ISO8859-1"),"GBK");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return value;
    }
}
