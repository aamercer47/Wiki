package com.java.wiki.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.wiki.domain.Ebook;
import com.java.wiki.domain.EbookExample;
import com.java.wiki.mapper.EbookMapper;
import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> list(EbookReq req){

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();//Criteria:相当于Where条件
        //动态SQL
        if(!ObjectUtils.isEmpty(req.getName())){//如果它不为空的判断
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());//动态查询
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数:{}",pageInfo.getTotal());//总行数
        LOG.info("总页数:{}",pageInfo.getPages());//总页数

        //持久层返回List<Eboook>需要转成List<EbookResp>再返回controller
//        List<EbookResp> respList=new ArrayList<>();
//        for (Ebook ebook : ebookList) {
////            EbookResp ebookResp = new EbookResp();
////            ebookResp.setId(ebook.getId());
////            BeanUtils.copyProperties(ebook,ebookResp);
//            //对象复制
//            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }

        //列表复制
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);


        return pageResp;
    }
}
