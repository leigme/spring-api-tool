package me.leig.server.spring.api.tool.service;

import me.leig.server.spring.api.tool.bean.ApiServiceBean;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/3
 **/
public abstract class AbstractRequestMappingHandler implements RequestMappingHandler {

    protected ApiServiceBean apiServiceBean;

    @Override
    public void handler(ApiServiceBean apiServiceBean) {
        this.apiServiceBean = apiServiceBean;
    }
}
