package com.tom.cloud.starter.common.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * FeignRequestInterceptor
 *
 * @author Tom.Zeng
 * @date 2019/5/28 18:57
 */
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    @Autowired
    private HttpServletRequest request;

    @Override
    public void apply(RequestTemplate requestTemplate) {

//        request.getParameterMap().entrySet()
//                .stream()
//                .forEach(entry -> requestTemplate.query(entry.getKey(), entry.getValue()));

        requestTemplate.query("lang", request.getParameter("lang"));
        requestTemplate.query("timestamp", request.getParameter("timestamp"));
    }
}
