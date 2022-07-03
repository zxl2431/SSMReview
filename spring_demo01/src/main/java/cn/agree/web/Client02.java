package cn.agree.web;

import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Client02 {

    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        accountService = (AccountService) ac.getBean("accountService");
    }

    /*
    * 保存
    * */
    @Test
    public void testSave() {
        Account account = new Account();
        account.setBalance(888f);
        account.setName("屁屁屁");

        accountService.save(account);
    }

    /*
    *  更新
    * */
    @Test
    public void testUpdate() {
        // 查出id=3的账户
        Account account = accountService.findById(4);
        System.out.println(account);
        account.setName("张似懂非懂");
        // 修改
        accountService.update(account);
    }

    /*
    *  删除
    * */
    @Test
    public void testDelete() {
        Integer accountId=3;
        accountService.delete(accountId);
    }

    /*
    * 根据id查询
    * */
    @Test
    public void testFindById() {
        Integer accountId = 4;
        Account account = accountService.findById(accountId);
        System.out.println(account);
    }

    /*
    *
    * 查询所有
    * */
    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


}
