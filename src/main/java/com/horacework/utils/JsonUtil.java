package com.horacework.utils;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class JsonUtil {

    private static Gson gson = new Gson();
    private static String errorStr;


    /**
     * @param src :将要被转化的对象
     * @return :转化后的JSON串
     * @MethodName : toJson
     * @Description : 将对象转为JSON串，此方法能够满足大部分需求
     */
    public static String toJson(JsonObj obj) {
        String str = "";
        if (obj == null) {
            str = gson.toJson(JsonNull.INSTANCE);
        }
        str = gson.toJson(obj);
        return str;
    }

    public static String toJson(Object object) {
        String str = "";
        if (object == null) {
            str = gson.toJson(JsonNull.INSTANCE);
        }
        str = gson.toJson(object);
        return str;
    }

}