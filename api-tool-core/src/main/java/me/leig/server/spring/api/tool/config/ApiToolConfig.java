package me.leig.server.spring.api.tool.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/3
 **/
public class ApiToolConfig extends PropertySourcesPlaceholderConfigurer {

    private static final long serialVersionUID = 2608109437315354933L;

    private String serviceName;

    @Override
    public void setProperties(Properties properties) {
        this.serviceName = properties.getProperty("api.tool.name", "");
    }

    public String getServiceName() {
        return serviceName;
    }
}
