package com.tom.cloud.starter.common.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller层异常捕获处理
 *
 * @author Tom.Zeng
 * @date 2019/5/28 17:15
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public RespVo handlerThrowable(Throwable e) {
        log.error("系统错误", e);
        return RespVo.failure(CodeEnum.SYSTEM_ERROR, e.getMessage());
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public RespVo handlerServiceException(BizException e) {
        return RespVo.failure(e.getCode(), e.getMsgArgs());
    }

    /**
     * 请求方法不支持
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RespVo handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return RespVo.failure(CodeEnum.PARAM_ERROR, e.getMessage());
    }

    /**
     * 请求Body不可读
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RespVo handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return RespVo.failure(CodeEnum.PARAM_ERROR, e.getMessage());
    }

    /**
     * 参数校验不通过
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespVo handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder builder = new StringBuilder(32);
        for(FieldError error : e.getBindingResult().getFieldErrors()) {
            builder.append(", [").append(error.getField()).append(":").append(error.getDefaultMessage()).append("]");
        }
        String msg = builder.substring(2);
        return RespVo.failure(CodeEnum.PARAM_ERROR, msg);
    }

}
