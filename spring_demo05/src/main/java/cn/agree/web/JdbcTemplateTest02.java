package cn.agree.web;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateTest02 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);


    }
}
