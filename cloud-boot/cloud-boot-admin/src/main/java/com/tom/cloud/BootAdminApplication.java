package com.tom.cloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BootAdminApplication
 *
 * @author Tom.Zeng
 * @date 2019/5/7 15:55
 */
@EnableApolloConfig
@EnableAdminServer
@SpringBootApplication
public class BootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminApplication.class, args);
    }
}
