package me.leig.server.spring.api.tool.bean;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/2
 **/
public class ApiServiceBean implements Serializable {

    private static final long serialVersionUID = 4190577594262146934L;

    private String serviceName;

    public ApiServiceBean() {}

    public ApiServiceBean(String serviceName) {
        this.serviceName = serviceName;
    }

    private List<RequestMappingBean> requestMappingBeanList;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<RequestMappingBean> getRequestMappingBeanList() {
        return requestMappingBeanList;
    }

    public void setRequestMappingBeanList(List<RequestMappingBean> requestMappingBeanList) {
        this.requestMappingBeanList = requestMappingBeanList;
    }

    public void addRequestMappingBean(RequestMappingBean requestMappingBean) {
        if (CollectionUtils.isEmpty(requestMappingBeanList)) {
            requestMappingBeanList = new ArrayList<>();
        }
        requestMappingBeanList.add(requestMappingBean);
    }

    @Override
    public String toString() {
        return "ApiServiceBean{" +
                "serviceName='" + serviceName + '\'' +
                ", requestMappingBeanList=" + Arrays.toString(requestMappingBeanList.toArray(new RequestMappingBean[0])) +
                '}';
    }
}
