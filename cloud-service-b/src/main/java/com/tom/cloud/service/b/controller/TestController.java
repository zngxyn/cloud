package com.tom.cloud.service.b.controller;

import com.tom.cloud.starter.common.RespVo;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public RespVo hello() {
        RespVo vo = RespVo.success();
        return vo;
    }

}
