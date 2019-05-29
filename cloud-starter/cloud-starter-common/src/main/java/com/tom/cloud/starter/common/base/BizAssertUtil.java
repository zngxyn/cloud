package com.tom.cloud.starter.common.base;

import java.util.Collection;

/**
 * 业务断言工具
 *
 * @author Tom.Zeng
 * @date 2019/5/29 10:21
 */
public class BizAssertUtil {

    /**
     * 期望表达式为true，否则抛出BizException
     * @param expression
     * @param code
     * @param msgArgs
     */
    public static void isTrue(boolean expression, Code code, Object... msgArgs) {
        if (expression) {
            return;
        }
        throw new BizException(code, msgArgs);
    }

    /**
     * 期望表达式为false，否则抛出BizException
     * @param expression
     * @param code
     * @param msgArgs
     */
    public static void isFalse(boolean expression, Code code, Object... msgArgs) {
        if (!expression) {
            return;
        }
        throw new BizException(code, msgArgs);
    }

    /**
     * 期望对象为null，否则抛出BizException
     * @param obj
     * @param code
     * @param msgArgs
     */
    public static void isNull(Object obj, Code code, Object... msgArgs) {
        if (obj == null) {
            return;
        }
        throw new BizException(code, msgArgs);
    }

    /**
     * 期望对象不为null，否则抛出BizException
     * @param obj
     * @param code
     * @param msgArgs
     */
    public static void isNotNull(Object obj, Code code, Object... msgArgs) {
        if (obj != null) {
            return;
        }
        throw new BizException(code, msgArgs);
    }

    /**
     * 期望集合为空(null or empty)，否则抛出BizException
     * @param collection
     * @param code
     * @param msgArgs
     */
    public static void isEmpty(Collection<?> collection, Code code, Object... msgArgs) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        throw new BizException(code, msgArgs);
    }

    /**
     * 期望集合不为空(not null and not empty)，否则抛出BizException
     * @param collection
     * @param code
     * @param msgArgs
     */
    public static void isNotEmpty(Collection<?> collection, Code code, Object... msgArgs) {
        if (collection != null && !collection.isEmpty()) {
            return;
        }
        throw new BizException(code, msgArgs);
    }

}
