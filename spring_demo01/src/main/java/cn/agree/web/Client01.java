package cn.agree.web;

import cn.agree.dao.AccountDao;
import cn.agree.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Client01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.saveAccount();
    }

    @Test
    public void testBeanFactory() {
        ClassPathResource resource = new ClassPathResource("bean.xml");

        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println(beanFactory.containsBean("accountService"));
        // 此时BeanFactory中并没有创建Bean
        AccountService accountService = (AccountService) beanFactory.getBean("accountService");

    }

    @Test
    public void testContextImpl() {
        // 从类路径下加载配置文件
        new ClassPathXmlApplicationContext("bean.xml");
        // 从磁盘路径下加载配置文件
        new FileSystemXmlApplicationContext("E://bean.xml");
        // 使用注解的时候 用这个
        new AnnotationConfigApplicationContext();

    }


}
