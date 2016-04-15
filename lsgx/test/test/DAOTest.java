package test;

import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.service.UserTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * Created by lin on 2015/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/spring-*.xml")
@ContextConfiguration(locations = { "classpath:/spring-mvc.xml", "classpath:/spring-mybatis.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager", defaultRollback = true)
public class DAOTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    private UserTestService userTestService;


    @Test
    @Transactional
    public void testErrorsave3() throws Exception {
        Usertest newUser=new Usertest();
        newUser.setAddress("test");
        newUser.setUsername("testlyj");
        userTestService.saveUsertestError(newUser);
    }

    @Test
    /**
     * 在service方法中加入事务标签，不控制事务回滚
     */
    @Transactional
//    @Transactional(noRollbackFor=com.abc.BusinessException.class)
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

}
