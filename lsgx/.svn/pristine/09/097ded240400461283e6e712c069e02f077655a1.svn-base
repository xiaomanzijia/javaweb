package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试基础类
 * 
 * @author  Jfeng
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/spring-*.xml")
@ContextConfiguration(locations = { "classpath:/spring-mvc.xml", "classpath:/spring-mybatis.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager", defaultRollback = true)
public class BaseTest extends AbstractJUnit4SpringContextTests
{
    @Test
    public void test(){
        System.out.println("logger = " + logger);

    }
}

