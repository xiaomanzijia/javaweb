package com.lsgx.admin.service;

import com.lsgx.admin.model.Testname;
import com.lsgx.admin.model.Usertest;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import test.BaseTest;

import javax.annotation.Resource;

public class TestNameServiceTest extends BaseTest
{
    @Resource
    private TestNameService testNameService;


    @Test
    public void testInsert()
    {        Testname t=new Testname();
        t.setName("qq");
        testNameService.insert(t);
    }

    @Test
    public void testUpddate()
    {
        Testname t=new Testname();
        t.setName("pp");
        testNameService.updateByPrimaryKey(t);
    }

    @Test
    public void testDelete()
    {
        Testname t=new Testname();
        t.setName("pp");
        testNameService.deleteByPrimaryKey(1);
    }




    
}

