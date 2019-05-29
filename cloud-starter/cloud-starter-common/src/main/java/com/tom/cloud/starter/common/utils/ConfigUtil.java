package com.tom.cloud.starter.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * EnvironmentUtil
 *
 * @author Tom.Zeng
 * @date 2019/5/28 18:03
 */
@Component
public class ConfigUtil {

    private static Environment ENV;

    private static String APPLICATION_NAME;

    @Autowired
    public void setEnvironment(Environment env) {
        ENV = env;
    }

    /**
     * 从ENV对象读取属性
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return ENV.getProperty(key);
    }

    /**
     * 获取ENV对象
     * @return
     */
    public static Environment getEnvironment() {
        return ENV;
    }

    /**
     * 获取应用名称
     * @return
     */
    public static String getApplicationName() {
        if (APPLICATION_NAME == null) {
            APPLICATION_NAME = ENV.getProperty("spring.application.name");
        }
        return APPLICATION_NAME;
    }
}
