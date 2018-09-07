package com.ebuy.tax.common.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * @author hdq
 * Json工具类
 */
public class JsonUtil {
    public static Object[] jsonToArray(String json) {
        JSONArray jSONArray = JSONArray.fromObject(json);
        return jSONArray.toArray();
    }

    public static String array2json(Object[] obj) {
        JSONArray j = JSONArray.fromObject(obj);
        return j.toString();
    }

    public static Map jsonToMap(String json) {
        Map classMap = new HashMap();
        Map map = (Map) JSONObject.toBean(JSONObject.fromObject(json),
                Map.class, classMap);
        return map;
    }

    public static Map jsonObjectToMap(JSONObject json) {
        Map classMap = new HashMap();
        Map map = (Map) JSONObject.toBean(json,
                Map.class, classMap);
        return map;
    }

    public static String map2json(Map map) {
        JSONObject j = JSONObject.fromObject(map);
        return j.toString();
    }

    @SuppressWarnings("unchecked")
    public static final <T> T jsonToBean(String json, Class<T> t) {
        return (T) JSONObject.toBean(JSONObject.fromObject(json), t);
    }

    public static final String beanToJsonStr(Object obj) {
        return JSONObject.fromObject(obj).toString();
    }

    public static final <T> T jsonObjctToBean(JSONObject obj, Class<T> t){
        return (T) JSONObject.toBean(obj,t);
    }
}
