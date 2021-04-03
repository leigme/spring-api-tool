package me.leig.server.spring.api.tool.service.impl;

import me.leig.server.spring.api.tool.service.AbstractRequestMappingHandler;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/3
 **/
public class RemoteRequestMappingHandler extends AbstractRequestMappingHandler {

    @Override
    public Boolean call() throws Exception {
        System.out.println(RemoteRequestMappingHandler.class.getName() + apiServiceBean);
        return null;
    }
}
