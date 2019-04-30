package com.tom.cloud.starter.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tom.cloud.starter.common.i18n.I18nUtils;

/**
 * RespVo
 *
 * @author Tom.Zeng
 * @date 2019/4/25 17:33
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespVo<T> {

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误消息动态参数，用于填充国际化中{0}占位符
     */
    private transient Object[] msgArgs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if (msg == null) {
            // 从国际化中读取错误消息
            setMsg(I18nUtils.getMessage(code, msgArgs));
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsgArgs(Object[] msgArgs) {
        this.msgArgs = msgArgs;
    }


    /**
     * ===========================================
     * 以下扩展
     * ===========================================
     */

    /**
     * 是否成功
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return ErrorCode.SUCCESS.equals(code);
    }

    /**
     * 是否失败
     * @return
     */
    @JsonIgnore
    public boolean isFailure() {
        return !this.isSuccess();
    }

    /**
     * 成功
     * @return
     */
    public static RespVo success() {
        return success(null);
    }

    /**
     * 成功，with data
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RespVo<T> success(T data) {
        RespVo<T> respVo = new RespVo<>();
        respVo.setCode(ErrorCode.SUCCESS);
        respVo.setData(data);
        return respVo;
    }

    /**
     * 失败
     * @param code
     * @return
     */
    public static RespVo failure(String code) {
        RespVo respVo = new RespVo();
        respVo.setCode(code);
        return respVo;
    }

    /**
     * 失败
     * @param code
     * @param msgArgs
     * @return
     */
    public static RespVo failure(String code, Object... msgArgs) {
        RespVo respVo = new RespVo();
        respVo.setCode(code);
        respVo.setMsgArgs(msgArgs);
        return respVo;
    }



}
