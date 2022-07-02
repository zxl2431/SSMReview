package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.dao.impl.AccountDaoImpl;
import cn.agree.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();


    @Override
    public void init() {
        System.out.println("AccountServiceImpl初始化了...");
    }

    @Override
    public void destory() {
        System.out.println("AccountServiceImpl销毁了...");
    }

    @Override
    public void saveAccount() {
        System.out.println("service层调用dao层");
        accountDao.saveAccount();
    }
}
