package com.lsgx.admin.service;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.model.*;
import com.lsgx.admin.model.vo.ArticleVO;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import test.BaseTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lin on 2015/12/29.
 */
public class AlipayTradeServiceTest extends BaseTest {

    @Resource
    private AlipayTradeService alipayTradeService;



    @Test
    public void testInsert()
    {


        AlipayTrade at=new AlipayTrade();
        at.setState("abc");
        at.setAmount(BigDecimal.valueOf(0.50));
        at.setCreatetime(new Date());
        alipayTradeService.insert(at);


      //  assertEquals(dbArticle.getCategory(),article.getCategory());


    }

    @Test
    public void testSelect()
    {


        AlipayTradeExample ate=new AlipayTradeExample();
        ate.createCriteria().andStateEqualTo("d");
        List<AlipayTrade> list=alipayTradeService.selectByExample(ate);
        System.out.println("list.size() = " + list.size());


      //  assertEquals(dbArticle.getCategory(),article.getCategory());


    }

}
