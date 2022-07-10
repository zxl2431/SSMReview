package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Override
    public int saveAccount(Account account) {
        return 0;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
