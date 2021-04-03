package me.leig.server.spring.api.tool.service;

import me.leig.server.spring.api.tool.bean.ApiServiceBean;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/2
 **/
public interface RequestMappingHandler extends Callable<Boolean> {

    void handler(ApiServiceBean apiServiceBean);

}
