package com.tom.cloud.starter.common.base;

/**
 * 错误码枚举
 *
 * @author Tom.Zeng
 * @date 2019/5/29 10:51
 */
public enum CodeEnum implements Code {

    /**
     * 成功
     */
    SUCCESS("0"),

    /**
     * 网关错误
     */
    GATEWAY_ERROR("1"),

    /**
     * 参数错误
     */
    PARAM_ERROR("2"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR("9")

    ;

    private String code;

    CodeEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
