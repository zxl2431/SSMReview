package cn.agree.service.impl;

import cn.agree.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户...");
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("更新了账户...");
    }

    @Override
    public int deleteAccount(int id) {
        System.out.println("删除了账户...");
        return 0;
    }
}
