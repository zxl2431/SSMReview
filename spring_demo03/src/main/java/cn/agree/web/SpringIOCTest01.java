package cn.agree.web;


import cn.agree.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOCTest01 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        // accountService.save();

        accountService.transfer("张三", "李四", 50.00f);
    }
}
