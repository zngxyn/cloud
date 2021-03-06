package com.tom.cloud.starter.common.log;

import com.tom.cloud.starter.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * HttpTraceLogFilter
 *
 * @author Tom.Zeng
 * @date 2019/5/29 11:22
 */
@Slf4j
public class HttpTraceLogFilter extends OncePerRequestFilter implements Ordered {

    @Autowired
    private HttpTraceLogProperties httpTraceLogProperties;

    public HttpTraceLogFilter() {
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 未开启时直接doFilter
        if (!httpTraceLogProperties.isEnabled()) {
            filterChain.doFilter(request, response);
            return;
        }

        // 计时
        long start = System.currentTimeMillis();

        // 包装成ContentCaching
        HttpContentCachingRequestWrapper requestWrapper = this.wrap(request);
        HttpContentCachingResponseWrapper responseWrapper = this.wrap(response);

        // 打印请求日志
        String reqPath = requestWrapper.getServletPath();
        String reqMethod = requestWrapper.getMethod();
        String reqParam = JsonUtil.toString(requestWrapper.getParameterMap());
        String reqBody = this.getRequestBody(requestWrapper);
        log.info(">>>>> {} {}, body={}, param={}", reqMethod, reqPath, reqBody, reqParam);

        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String respBody = "[UNKNOWN]";
        try {
            // 执行filter
            filterChain.doFilter(requestWrapper, responseWrapper);

            // 取出执行结果
            status = responseWrapper.getStatus();
            respBody = this.getResponseBody(responseWrapper);
        } catch (Throwable e) {
            respBody = "[EXCEPTION]";
            throw e;
        } finally {
            // 打印返回日志
            log.info("<<<<< {} {}, {}/{}ms, body={}",
                    reqMethod,
                    reqPath,
                    status,
                    System.currentTimeMillis() - start,
                    respBody
            );
        }
    }

    /**
     * 包装request
     * @param request
     * @return
     */
    private HttpContentCachingRequestWrapper wrap(HttpServletRequest request) {
        if (request instanceof HttpContentCachingRequestWrapper) {
            return (HttpContentCachingRequestWrapper) request;
        }
        return new HttpContentCachingRequestWrapper(request);
    }

    /**
     * 包装response
     * @param response
     * @return
     */
    private HttpContentCachingResponseWrapper wrap(HttpServletResponse response) {
        if (response instanceof HttpContentCachingResponseWrapper) {
            return (HttpContentCachingResponseWrapper) response;
        }
        return new HttpContentCachingResponseWrapper(response);
    }

    /**
     * 读取request body数据
     * @param requestWrapper
     * @return
     * @throws UnsupportedEncodingException
     */
    private String getRequestBody(HttpContentCachingRequestWrapper requestWrapper) throws UnsupportedEncodingException {
        // multipart/form-data不读取
        String contentType = requestWrapper.getContentType();
        if (StringUtils.contains(contentType, MediaType.MULTIPART_FORM_DATA_VALUE)) {
            return contentType;
        }
        String reqBody = new String(requestWrapper.getBody(), requestWrapper.getCharacterEncoding());
        // json格式化，去除空格换行等
        // 仅用于开发调试，会影响性能，生产请关闭
        if (httpTraceLogProperties.isForceJsonOneLine() && StringUtils.contains(contentType, MediaType.APPLICATION_JSON_VALUE)) {
            reqBody = JsonUtil.toString(JsonUtil.toObject(reqBody, Map.class));
        }
        return reqBody;
    }

    /**
     * 读取response body数据
     * @param responseWrapper
     * @return
     * @throws IOException
     */
    private String getResponseBody(HttpContentCachingResponseWrapper responseWrapper) throws IOException {
        // multipart/form-data不读取
        String contentType = responseWrapper.getContentType();
        if (StringUtils.contains(contentType, MediaType.MULTIPART_FORM_DATA_VALUE)) {
            return contentType;
        }
        String respBody = IOUtils.toString(responseWrapper.getContentInputStream(), responseWrapper.getCharacterEncoding());
        // important!
        responseWrapper.copyBodyToResponse();
        return respBody;
    }

}
