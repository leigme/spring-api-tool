package me.leig.server.spring.api.tool.config;

import me.leig.server.spring.api.tool.service.RequestMappingHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/3
 **/
public class HandlerConditionalOnMiss implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ApplicationContext applicationContext = (ApplicationContext) context;
        RequestMappingHandler handler = applicationContext.getBean(RequestMappingHandler.class);

        return false;
    }
}
