package cn.agree.mapper;

import cn.agree.domain.Account;


import java.util.List;

public interface AccountMapper {

    /*
    *  查询账户信息
    * */
    // List<AccountCustomer> findAccountList();

    List<Account> findAccountList2();

    /*
    *  查询账户信息
    *
    * */
    List<Account> findAccounts();
}
