package com.lsgx.admin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsgx.admin.mapper.SystemLogMapper;
import com.lsgx.admin.model.ActionRole;
import com.lsgx.admin.model.SystemLog;
import com.lsgx.admin.model.Usertest;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import test.BaseTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class UserTestServiceTest extends BaseTest
{
    @Resource
    private UserTestService userTestService;
    @Resource
    private ActionRoleService actionRoleService;


    @Test
      @Transactional
      @Rollback(true)
      public void test()
{


    Usertest userTest= userTestService.queryById(1);
    System.out.println(userTest);
}


    @Test
    /**
     * 在service方法中加入事务标签，然后手动控制事务回滚。
     */
    public void testErrorsave() throws Exception {

//        try {
            Usertest newUser=new Usertest();
            newUser.setAddress("test");
            newUser.setUsername("testlyj");
            userTestService.saveErrorTransactionalUserTest(newUser);
//            Usertest newUser2=null;
//            userTestService.saveUsertest(newUser2);
//        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
    }

    @Test
    /**
     * 在service方法中加入事务标签，不控制事务回滚
     */
    public void testErrorsave2() throws Exception {

        try {
            Usertest newUser=new Usertest();
            newUser.setAddress("test");
            newUser.setUsername("testlyj");
            userTestService.saveErrorTransactionalUserTest2(newUser);
            Usertest newUser2=null;
            userTestService.saveUsertest(newUser2);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }


    @Test
    /**
     * 在service方法中加入事务标签，不控制事务回滚
     */
    public void testErrorsave3() throws Exception {
            Usertest newUser=new Usertest();
            newUser.setAddress("test");
            newUser.setUsername("testlyj");
            userTestService.saveUsertestError(newUser);
    }


    @Test
    /**
     * 在service方法中加入事务标签，可以实现数据插入
     */
    public void testErrorsave4()  {
            Usertest newUser=new Usertest();
            newUser.setAddress("test1");
            newUser.setUsername("testlyj2");
            userTestService.saveUsertest(newUser);

        //ActionRole role=actionRoleService.queryRoleList()
    }


    @Test
    /**
     * 在service方法中加入事务标签，出错后回滚
     */
    public void testErrorsave5()  {
        Usertest newUser=new Usertest();
        newUser.setAddress("test1");
        newUser.setUsername("testlyj2");
        userTestService.saveUsertestError(newUser);

        //ActionRole role=actionRoleService.queryRoleList()
    }
    @Test
    /**
     * 在service方法中加入事务标签，手动控制事务回滚。
     */
    public void testErrorsave6()  {
        Usertest newUser=new Usertest();
        newUser.setAddress("test1");
        newUser.setUsername("testlyj2");
        userTestService.saveErrorTransactionalUserTestWithException(newUser);

        //ActionRole role=actionRoleService.queryRoleList()
    }

    
}

