package cn.agree.service.impl;

import cn.agree.service.AccountService;
import org.springframework.stereotype.Service;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount(int a) {
        System.out.println("saveAccount-----------");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("updateAccount---------");
    }

    @Override
    public int deleteAccount() {
        System.out.println("deleteAccount-----------");
        return 1;
    }
}
