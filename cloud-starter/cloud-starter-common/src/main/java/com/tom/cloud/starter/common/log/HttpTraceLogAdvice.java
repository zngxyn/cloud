package com.tom.cloud.starter.common.log;

import com.tom.cloud.starter.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpTraceLogAdvice
 *
 * @author Tom.Zeng
 * @date 2019/5/28 19:06
 */
//@Aspect
//@Order(1)
//@Component
@Slf4j
@Deprecated
public class HttpTraceLogAdvice {

    private static final String TIME = "_start_time_";

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* com..*.controller..*.*(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        request.setAttribute(TIME, System.currentTimeMillis());
        log.info(">>>>> {}, param={}", request.getServletPath(), JsonUtil.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void finish(Object result) {
        log.info("<<<<< {} << {}ms << {}", request.getServletPath(), time(), JsonUtil.toString(result));
    }

    private long time() {
        Object obj = request.getAttribute(TIME);
        return obj != null ? (System.currentTimeMillis() - (Long) obj) : 0;
    }

}
