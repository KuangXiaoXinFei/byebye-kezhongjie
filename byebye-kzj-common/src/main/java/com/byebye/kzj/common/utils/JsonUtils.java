package com.byebye.kzj.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

public class JsonUtils {
    public JsonUtils() {
    }

    public static String formateObject() {
        String result = JSON.toJSONString(new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        return result;
    }

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    public static String formateMap(Map po) {
        String result = JSON.toJSONString(po, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        System.out.println(result);
        return result;
    }
}
