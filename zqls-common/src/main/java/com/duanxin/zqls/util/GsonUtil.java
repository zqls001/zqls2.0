package com.duanxin.zqls.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 基于Gson封装的json工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/18 9:27
 */
public class GsonUtil {

    private static Gson gson;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private GsonUtil() {
    }

    /**
     * 将对象转化为json
     * @param object 对象
     * @date 2019/10/18 9:29
     * @return java.lang.String
     **/
    public static String objectToString(Object object) {
        String json = null;
        if (gson != null) {
            json = gson.toJson(object);
        }
        return json;
    }

    /**
     * 将json转化为对象
     * @param json 待转化的json
     * @param clazz 转化对象类型
     * @date 2019/10/18 9:33
     * @return T
     **/
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(json, clazz);
        }
        return t;
    }

    /**
     * 将json转化为list集合
     * @param json 待转化的json
     * @param clazz 转化对象类型
     * @date 2019/10/18 9:36
     * @return T
     **/
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<>();
        JsonArray asJsonArray = JsonParser.parseString(json).getAsJsonArray();
        for (final JsonElement element : asJsonArray) {
            list.add(gson.fromJson(element, clazz));
        }
        return list;
    }

    /**
     * 转化list中有map的
     * @param json 待转化的json
     * @date 2019/10/18 9:44
     * @return java.util.List<java.util.Map<java.lang.String,T>>
     **/
    public static <T> List<Map<String, T>> jsonToListMaps(String json) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(json,
                    new TypeToken<List<Map<String, T>>>(){
                    }.getType());
        }
        return list;
    }

    /**
     * 转化map集合
     * @param json 待转化的json
     * @date 2019/10/18 9:47
     * @return java.util.Map<java.lang.String,T>
     **/
    public static <T> Map<String, T> jsonToMaps(String json) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(json,
                    new TypeToken<Map<String, T> > () {
            }.getType());
        }
        return map;
    }
}
