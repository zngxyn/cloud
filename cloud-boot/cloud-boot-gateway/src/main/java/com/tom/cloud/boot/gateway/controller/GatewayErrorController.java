package com.tom.cloud.boot.gateway.controller;

import com.tom.cloud.starter.common.base.RespVo;
import com.tom.cloud.starter.common.base.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * GatewayErrorController
 *
 * @author Tom.Zeng
 * @date 2019/4/30 15:00
 */
@Slf4j
@RestController
public class GatewayErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public RespVo error(HttpServletRequest request, HttpServletResponse response) {
        /**
         * javax.servlet.error.status_code 错误码
         * javax.servlet.error.message     错误消息
         * javax.servlet.error.exception   异常对象
         * =========================================
         * See at SendErrorFilter
         */
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String message = (String) request.getAttribute("javax.servlet.error.message");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        if (exception != null) {
            log.error("exception", exception);
            if (StringUtils.isEmpty(message)) {
                message = exception.getMessage();
            }
        }
        if (StringUtils.isEmpty(message)) {
            HttpStatus resolveStatus =  HttpStatus.resolve(code);
            if (resolveStatus != null) {
                message = resolveStatus.getReasonPhrase();
            }
        }

        response.setStatus(HttpStatus.OK.value());
        return RespVo.failure(CodeEnum.GATEWAY_ERROR, code, message);
    }
}
