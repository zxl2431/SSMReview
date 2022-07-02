package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("持久层保存了账户!");
    }
}
