package cn.agree.web;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateTest02 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        // accountDaoImpl2是实现了JdbcDaoSupport的 只能用xml的方式,不能使用注解的方式
        AccountDao accountDao1 = (AccountDao) applicationContext.getBean("accountDao1");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        Account account1 = accountDao1.findAccountById(2);
        System.out.println(account1);


    }
}
