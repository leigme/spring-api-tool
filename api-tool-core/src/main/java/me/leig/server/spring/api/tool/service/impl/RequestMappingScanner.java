package me.leig.server.spring.api.tool.service.impl;

import me.leig.server.spring.api.tool.bean.ApiServiceBean;
import me.leig.server.spring.api.tool.bean.RequestMappingBean;
import me.leig.server.spring.api.tool.config.ApiToolConfig;
import me.leig.server.spring.api.tool.service.RequestMappingHandler;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/2
 **/
public class RequestMappingScanner implements ApplicationContextAware {

    @Autowired
    private ApiToolConfig apiToolConfig;

    @Autowired
    private RequestMappingHandler requestMappingHandler;

    @Autowired
    private ExecutorService executorService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> objectMap = applicationContext.getBeansWithAnnotation(RestController.class);
        ApiServiceBean apiServiceBean = new ApiServiceBean(apiToolConfig.getServiceName());
        for (Map.Entry<String, Object> objectEntry: objectMap.entrySet()) {
            Class<? extends Object> clazz = AopUtils.getTargetClass(objectEntry.getValue());
            if (clazz.isAnnotationPresent(RequestMapping.class)) {
                String[] classRequestMappings = clazz.getAnnotation(RequestMapping.class).value();
                for (String classRequestMapping: classRequestMappings) {
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method method: methods) {
                        String[] methodRequestMappings = method.getAnnotation(RequestMapping.class).value();
                        for (String methodRequestMapping: methodRequestMappings) {
                            RequestMappingBean requestMappingBean = new RequestMappingBean();
                            requestMappingBean.setPath(classRequestMapping, methodRequestMapping);
                            requestMappingBean.setParameters(method.getParameters());
                            requestMappingBean.setReturnType(method.getReturnType());
                            apiServiceBean.addRequestMappingBean(requestMappingBean);
                        }
                    }
                }
            } else {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method: methods) {
                    String[] methodRequestMappings = method.getAnnotation(RequestMapping.class).value();
                    for (String methodRequestMapping: methodRequestMappings) {
                        RequestMappingBean requestMappingBean = new RequestMappingBean();
                        requestMappingBean.setPath(methodRequestMapping);
                        requestMappingBean.setParameters(method.getParameters());
                        requestMappingBean.setReturnType(method.getReturnType());
                        apiServiceBean.addRequestMappingBean(requestMappingBean);
                    }
                }
            }
        }
        requestMappingHandler.handler(apiServiceBean);
        executorService.submit(requestMappingHandler);
    }

}
