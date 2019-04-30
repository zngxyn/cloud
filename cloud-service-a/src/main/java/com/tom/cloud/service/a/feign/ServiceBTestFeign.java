package com.tom.cloud.service.a.feign;

import com.tom.cloud.starter.common.RespVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ServiceBTestFeign
 *
 * @author Tom.Zeng
 * @date 2019/4/30 14:29
 */
@FeignClient(name = "cloud-service-b")
@RequestMapping("/service-b/test")
public interface ServiceBTestFeign {


    @GetMapping("/hello")
    RespVo hello();

}
