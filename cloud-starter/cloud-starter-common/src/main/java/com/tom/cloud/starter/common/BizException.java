package com.tom.cloud.starter.common;

/**
 * BizException
 *
 * @author Tom.Zeng
 * @date 2019/4/25 17:52
 */
public class BizException extends RuntimeException {

    private String code;
    private Object[] msgArgs;

    public BizException(String code) {
        this.code = code;
    }

    public BizException(String code, Object... msgArgs) {
        this.code = code;
        this.msgArgs = msgArgs;
    }

    public String getCode() {
        return code;
    }

    public Object[] getMsgArgs() {
        return msgArgs;
    }
}
