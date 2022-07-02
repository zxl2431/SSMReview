package cn.agree.test;

import cn.agree.service.impl.AccountServiceImpl;

public class SpringIOCTest01 {
    public static void main(String[] args) {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
