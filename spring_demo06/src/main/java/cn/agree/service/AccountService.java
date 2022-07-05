package cn.agree.service;

import cn.agree.domain.Account;

public interface AccountService {

    Account findAccountById(Integer id);

    void transfer(String sourceName, String targetName, Float money);

}
