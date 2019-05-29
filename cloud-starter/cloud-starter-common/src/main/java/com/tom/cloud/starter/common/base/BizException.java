package com.tom.cloud.starter.common.base;

/**
 * BizException
 *
 * @author Tom.Zeng
 * @date 2019/4/25 17:52
 */
public class BizException extends RuntimeException {

    private Code code;
    private Object[] msgArgs;

    public BizException(Code code) {
        this.code = code;
    }

    public BizException(Code code, Object... msgArgs) {
        this.code = code;
        this.msgArgs = msgArgs;
    }

    public Code getCode() {
        return code;
    }

    public Object[] getMsgArgs() {
        return msgArgs;
    }
}
