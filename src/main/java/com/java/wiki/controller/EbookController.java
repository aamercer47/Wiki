package com.java.wiki.controller;
//开发HelloWorld接口

import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //返回字符串
//@Controller  //返回页面
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq req){
        CommonResp<List<EbookResp>> resp = new CommonResp<>();//<object>泛型是实际返回业务数据的类型，即content的类型
        List<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }


}

