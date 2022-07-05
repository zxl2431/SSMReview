package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        // 1.根据名称查询两个账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        // 2.修改两个账户的金额
        source.setBalance(source.getBalance() - money);
        target.setBalance(target.getBalance() + money);
        // 3.更新两个账户余额
        accountDao.updateAccount(source);
        // int i=1/0;
        accountDao.updateAccount(target);




    }
}
