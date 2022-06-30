package cn.agree.mapper;

import cn.agree.domain.Account;
import cn.agree.domain.AccountCustomer;

import java.util.List;

public interface AccountMapper {

    /*
    *  查询账户信息
    * */
    List<AccountCustomer> findAccountList();

    List<Account> findAccountList2();
}
