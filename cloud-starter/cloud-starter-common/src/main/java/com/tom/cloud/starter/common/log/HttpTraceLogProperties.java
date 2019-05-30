package com.tom.cloud.starter.common.log;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * HttpTraceLogProperties
 *
 * @author Tom.Zeng
 * @date 2019/5/30 12:16
 */
@Data
@ConfigurationProperties(prefix = "http.trace.log")
public class HttpTraceLogProperties {

    /**
     * 开关：true开启/false关闭
     */
    private boolean enabled = true;

    /**
     * 强制json字符串在一行显示
     * 在开发调式阶段传入的json是被格式化的，未了避免输出日志格式混乱，强制删除换行、空格等
     * 会影响性能，生产环境请关闭
     */
    private boolean forceJsonOneLine = false;

}
