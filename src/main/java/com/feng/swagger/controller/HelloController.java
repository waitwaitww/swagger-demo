package com.feng.swagger.controller;

import com.feng.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Hello控制类")
@RestController
public class HelloController {

    @ApiOperation("Hello控制类")  //接口Api
    @RequestMapping("/hello")
    public String hello(@ApiParam("用户名") String name){
        return "hello";
    }

    @GetMapping("/user")
    public User getUser(){
        return new User();
    }
}
