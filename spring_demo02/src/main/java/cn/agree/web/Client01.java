package cn.agree.web;

import cn.agree.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client01 {
    public static void main(String[] args) {
        // 获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.save();

    }
}
