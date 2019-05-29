package com.tom.cloud.starter.common.log;

import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletResponse;

/**
 * HttpContentCachingResponseWrapper
 *
 * @author Tom.Zeng
 * @date 2019/5/29 16:54
 */
public class HttpContentCachingResponseWrapper extends ContentCachingResponseWrapper {

    public HttpContentCachingResponseWrapper(HttpServletResponse response) {
            super(response);
    }

}
