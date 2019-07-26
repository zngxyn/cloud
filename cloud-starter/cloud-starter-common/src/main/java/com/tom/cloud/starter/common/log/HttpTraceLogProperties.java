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
     * enable http trace log
     */
    private boolean enabled = true;

    /**
     * Force the json string to a line. Enabled only during debugging
     */
    private boolean forceJsonOneLine = false;

}
