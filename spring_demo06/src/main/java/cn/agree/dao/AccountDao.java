package cn.agree.dao;

import cn.agree.domain.Account;

public interface AccountDao {

    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
