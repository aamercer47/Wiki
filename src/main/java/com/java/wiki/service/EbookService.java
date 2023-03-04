package com.java.wiki.service;


import com.java.wiki.domain.Ebook;
import com.java.wiki.domain.EbookExample;
import com.java.wiki.mapper.EbookMapper;
import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();//Criteria:相当于Where条件
        criteria= criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
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

        return list;
    }
}
