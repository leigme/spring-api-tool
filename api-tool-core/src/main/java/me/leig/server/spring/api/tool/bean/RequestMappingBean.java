package me.leig.server.spring.api.tool.bean;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/2
 **/
public class RequestMappingBean implements Serializable {

    private static final long serialVersionUID = 7902781169824530519L;

    public static final String pathSeparator = "/";

    private String path;

    private Parameter[] parameters;

    private Class<?> returnType;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.setPath(null, path);
    }

    public void setPath(String prefix, String path) {
        if (StringUtils.hasText(prefix)) {
            if (!prefix.startsWith(pathSeparator)) {
                prefix = pathSeparator + prefix;
            }
            if (prefix.endsWith(pathSeparator)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        if (!path.startsWith(pathSeparator)) {
            path = pathSeparator + path;
        }
        this.path = prefix + path;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "RequestMappingBean{" +
                "path='" + path + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                ", returnType=" + returnType +
                '}';
    }
}
