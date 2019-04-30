package com.tom.cloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * BootGatewayApplication
 *
 * @author Tom.Zeng
 * @date 2019/4/26 14:38
 */
@EnableEurekaClient
@EnableApolloConfig
@EnableZuulProxy
@SpringBootApplication
public class BootGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGatewayApplication.class, args);
    }

}
