package com.tom.cloud.starter.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * JsonUtil
 *
 * @author Tom.Zeng
 * @date 2019/5/29 14:43
 */
public class JsonUtil {

    private static ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 对象转JSON字符串
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("对象转换为JSON字符串异常", e);
        }
    }

    /**
     * JSON字符串转对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON字符串转换为对象异常", e);
        }
    }

}
