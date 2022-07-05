package cn.agree.web;

import cn.agree.domain.Account;
import cn.agree.service.AccountService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTXText01 {

    @Test
    public void testSpringTransactionXML() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");

        // System.out.println(accountService);
        // 根据ID查找
        // Account account = accountService.findAccountById(2);
        // System.out.println(account);

        // 转账 张三转给李四
        accountService.transfer("张三", "李四", 50f);

        // 转账李四转给张三
        // accountService.transfer("李四", "张三", 50f);
    }

}
