package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        int count = accountDao.saveAccount(account);
        System.out.println(account);
    }

    @Override
    public List<Account> findAll() {
        System.out.println("正在执行findAll...");

        return accountDao.findAll();
    }
}
