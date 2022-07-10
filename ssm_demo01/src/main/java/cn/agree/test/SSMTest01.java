package cn.agree.test;

import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SSMTest01 {

    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        accountService = (AccountService) act.getBean("accountService");
    }

    @Test
    public void testFindAll() {
        List<Account> all = accountService.findAll();
    }


}
