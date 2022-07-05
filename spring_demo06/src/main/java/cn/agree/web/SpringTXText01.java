package cn.agree.web;

import cn.agree.SpringConfiguration;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Test
    public void testSpringTransactionAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        DataSource ds = (DataSource) applicationContext.getBean("dataSource");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");

        Account account = accountService.findAccountById(2);

        System.out.println(account);

        // 转账 张三转给李四
        accountService.transfer("张三", "李四", 50f);

        /*List<Account> accounts = jdbcTemplate.query("select * from account where id=2", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();

                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                float balance = rs.getFloat("balance");
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                return account;
            }
        });

        System.out.println(accounts.get(0));*/




    }

}
