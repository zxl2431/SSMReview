package cn.agree.web;

import cn.agree.SpringConfiguration;
import cn.agree.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopTest {

    /*
    *  AOP
    *
    * */
    @Test
    public void testAop() {
        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);

        accountService.saveAccount(8);
    }
}
