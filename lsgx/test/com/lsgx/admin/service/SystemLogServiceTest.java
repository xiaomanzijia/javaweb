package com.lsgx.admin.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import test.BaseTest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsgx.admin.mapper.SystemLogMapper;
import com.lsgx.admin.model.SystemLog;
public class SystemLogServiceTest extends BaseTest
{
    @Resource
    private SystemLogService systemLogService;
    
    @Resource
    private SystemLogMapper systemLogDao;

    @Test
    @Transactional
    @Rollback(true)
    public void test()
    {
        SystemLog log = new SystemLog();
        log.setUserName("admin");
        log.setRealName("admin");
        log.setOperateTime(new Date());
        log.setIP("127.0.0.1");
        log.setUrl("/.do222222222");
        log.setContent("");
        log.setOperateType("");
        log.setDetails("");
        
        systemLogService.save(log);
    }
    
    @Test
    public void testQueryAll()
    {
        PageHelper.startPage(1, 20);
        List<SystemLog> list = systemLogDao.findAll();
        
        Page<SystemLog> page = (Page<SystemLog>)list;
        PageInfo<SystemLog> page2 = new PageInfo<SystemLog>(list);
        System.out.println(page2);
        //        System.out.println(list.get(0));
        //        System.out.println(list.get(1));
        //        Assert.assertEquals(10, list.size());
    }
    
}

