package cn.agree.dao;

import cn.agree.domain.Account;

public interface AccountDao {

    void save();

    Account findByName(String name);

    int update(Account account);
}
