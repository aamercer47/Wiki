package com.java.wiki.controller;

import com.java.wiki.req.UserQueryReq;
import com.java.wiki.req.UserSaveReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.resp.UserQueryResp;
import com.java.wiki.service.UserService;
import com.java.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private SnowFlake snowFlake;

//    @Resource
//    private RedisTemplate redisTemplate;

    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req) {
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> list = userService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }

//    @PostMapping("/reset-password")
//    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
//        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
//        CommonResp resp = new CommonResp<>();
//        userService.resetPassword(req);
//        return resp;
//    }

//    @PostMapping("/login")
//    public CommonResp login(@Valid @RequestBody UserLoginReq req) {
//        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
//        CommonResp<UserLoginResp> resp = new CommonResp<>();
//        UserLoginResp userLoginResp = userService.login(req);
//
//        Long token = snowFlake.nextId();
//        LOG.info("生成单点登录token：{}，并放入redis中", token);
//        userLoginResp.setToken(token.toString());
//        redisTemplate.opsForValue().set(token.toString(), JSONObject.toJSONString(userLoginResp), 3600 * 24, TimeUnit.SECONDS);
//
//        resp.setContent(userLoginResp);
//        return resp;
//    }
//
//    @GetMapping("/logout/{token}")
//    public CommonResp logout(@PathVariable String token) {
//        CommonResp resp = new CommonResp<>();
//        redisTemplate.delete(token);
//        LOG.info("从redis中删除token: {}", token);
//        return resp;
//    }
}
