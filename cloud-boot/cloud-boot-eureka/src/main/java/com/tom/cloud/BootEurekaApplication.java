package com.tom.cloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * BootEurekaApplication
 *
 * @author Tom.Zeng
 * @date 2019/4/26 14:13
 */
@EnableApolloConfig
@EnableEurekaServer
@SpringBootApplication
public class BootEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run( BootEurekaApplication.class, args);
    }

}
