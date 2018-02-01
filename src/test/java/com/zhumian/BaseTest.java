package com.zhumian;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/16 0:04
 */
@ContextConfiguration(locations = {
        "classpath:spring/applicationContext.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true不会改变数据库，false会改变数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class BaseTest {
}
