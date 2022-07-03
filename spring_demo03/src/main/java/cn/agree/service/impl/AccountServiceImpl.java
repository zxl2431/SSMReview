package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        accountDao.save();
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        // 根据名字查询账户信息
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        System.out.println(source);

        // 转出账户减钱 转入账户价钱
        source.setBalance(source.getBalance()-money);
        target.setBalance(target.getBalance()+money);
        // 更新两个账户
        accountDao.update(source);
        // 出现了异常
        int i=1/0;
        accountDao.update(target);

    }
}
