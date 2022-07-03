package cn.agree.web;

import cn.agree.SpringConfiguration;
import cn.agree.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client02 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.save();

    }
}
