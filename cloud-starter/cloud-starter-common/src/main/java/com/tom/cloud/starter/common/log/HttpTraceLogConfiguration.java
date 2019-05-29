package com.tom.cloud.starter.common.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HttpTraceLogConfiguration
 *
 * @author Tom.Zeng
 * @date 2019/5/29 11:31
 */
@Slf4j
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class HttpTraceLogConfiguration {

    @Bean
    public HttpTraceLogFilter httpTraceLogFilter() {
        HttpTraceLogFilter httpTraceLogFilter = new HttpTraceLogFilter();
        log.info("HttpTraceLogFilter has been initialized.");
        return httpTraceLogFilter;
    }
}
