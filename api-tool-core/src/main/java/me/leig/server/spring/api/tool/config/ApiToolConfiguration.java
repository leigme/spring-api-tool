package me.leig.server.spring.api.tool.config;

import me.leig.server.spring.api.tool.service.RequestMappingHandler;
import me.leig.server.spring.api.tool.service.impl.LocalRequestMappingHandler;
import me.leig.server.spring.api.tool.service.impl.RequestMappingScanner;
import me.leig.server.spring.api.tool.service.impl.ThreadPoolFactoryImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.concurrent.ExecutorService;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/2
 **/
@Configuration
public class ApiToolConfiguration {

    @Bean
    public ApiToolConfig apiToolConfig() {
        ApiToolConfig apiToolConfig = new ApiToolConfig();
        Resource resource = new ClassPathResource("api-tool.properties");
        if (resource.exists()) {
            apiToolConfig.setLocation(resource);
        }
        return apiToolConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestMappingHandler requestMappingHandler() {
        return new LocalRequestMappingHandler();
    }

    @Bean
    public RequestMappingScanner requestMappingScanner() {
        return new RequestMappingScanner();
    }

    @Bean
    public ExecutorService executorService() {
        return ThreadPoolFactoryImpl.INSTANCE.newSingleThreadExecutor();
    }
}
