package com.tom.cloud.service.b.controller;

import com.tom.cloud.starter.common.base.RespVo;
import com.tom.cloud.starter.common.base.CodeEnum;
import com.tom.cloud.starter.common.base.BizAssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author Tom.Zeng
 * @date 2019/4/30 10:37
 */
@Slf4j
@RestController
@RequestMapping("/service-b/test")
public class TestController {

    @GetMapping("/hello")
    public RespVo hello() {
        log.info("hello");
        BizAssertUtil.isNotNull(null, CodeEnum.SYSTEM_ERROR, "12345");
        return RespVo.success("i am service b");
    }

}
