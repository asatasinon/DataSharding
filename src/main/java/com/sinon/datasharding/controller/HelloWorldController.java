package com.sinon.datasharding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloWorldController
 * @Description TODO
 * @Date 2021/3/3 11:08
 * @Created by sinon
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello/{userName}")
    public String hello(@PathVariable String userName){
        return "hello:" + userName;
    }
}
