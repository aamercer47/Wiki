package com.java.wiki.controller;
//开发HelloWorld接口

import com.java.wiki.domain.Test;
import com.java.wiki.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController //返回字符串
//@Controller  //返回页面
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate redisTemplate;

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
        return "Hello World!"+testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "Hello world! Post, "+name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){

        return testService.list();
    }

    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key);
        LOG.info("key: {}, value: {}", key, object);
        return object;
    }

}

