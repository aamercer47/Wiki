package com.java.wiki.controller;
//开发HelloWorld接口
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //返回字符串
//@Controller  //返回页面
public class TestController {
    //http://127.0.0.1:8880/hello
    ///常见的http请求方式有4种 GET,POST,PUT,DELETE
     // 通过id来访问用户：/user?id=1或/user/1
    // @PostMapping
    // @PutMapping
    // @DeleteMapping
    // @RequestMapping(value = "/user/1", method = RequestMethod.GET)
    // @RequestMapping(value = "/user/1", method = RequestMethod.DELETE)

    //@RequestMapping("/hello") //hello接口地址  //RequestMapping支持所有请求方式
    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }
}
