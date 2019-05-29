package com.tom.cloud.starter.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tom.cloud.starter.common.i18n.I18nUtil;
import com.tom.cloud.starter.common.utils.ConfigUtil;

/**
 * 统一返回对象，支持国际化
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
    private String message;

    /**
     * 服务ID
     */
    private String service;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误消息动态参数，用于填充国际化中{0}占位符
     */
    private transient Object[] msgArgs;

    public RespVo() {
        // 从配置文件读取应用名称
        this.service = ConfigUtil.getApplicationName();
    }

    /**
     * ===========================================
     * getter and setter
     * ===========================================
     */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        /**
         * 1、错误消息懒加载（用到才加载）
         * 2、国际化
         * 3、只读取一次
         */
        if (message == null) {
            setMessage(I18nUtil.getMessage(code, msgArgs));
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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
        return CodeEnum.SUCCESS.getCode().equals(code);
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
        respVo.setCode(CodeEnum.SUCCESS.getCode());
        respVo.setData(data);
        return respVo;
    }

    /**
     * 失败
     * @param code
     * @return
     */
    public static RespVo failure(Code code) {
        RespVo respVo = new RespVo();
        respVo.setCode(code.getCode());
        return respVo;
    }

    /**
     * 失败
     * @param code
     * @param msgArgs
     * @return
     */
    public static RespVo failure(Code code, Object... msgArgs) {
        RespVo respVo = new RespVo();
        respVo.setCode(code.getCode());
        respVo.setMsgArgs(msgArgs);
        return respVo;
    }



}
