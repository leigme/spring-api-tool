package me.leig.server.spring.boot.sample.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/3
 **/
@RestController
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestBody String name) {
        return "hello " + name;
    }

}
