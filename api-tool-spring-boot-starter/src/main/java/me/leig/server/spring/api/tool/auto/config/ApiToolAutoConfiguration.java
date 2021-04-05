package me.leig.server.spring.api.tool.auto.config;

import me.leig.server.spring.api.tool.config.ApiToolConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/5
 **/
@Configuration
@Import(ApiToolConfiguration.class)
public class ApiToolAutoConfiguration {

}
