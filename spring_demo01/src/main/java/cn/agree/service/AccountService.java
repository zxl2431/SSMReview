package cn.agree.service;

import cn.agree.domain.Account;

import java.util.List;

public interface AccountService {

    void init();

    void destory();

    /*
    *  模拟保存账号
    * */
    // void saveAccount();

    /*
    *  保存账户
    * */
    void save(Account account);

    /*
    * 更新
    * */
    void update(Account account);

    /*
    *  删除
    * */
    void delete(Integer accountId);

    /*
    *  根据Id查询
    * */
    Account findById(Integer accountId);

    /*
    *  查询所有
    * */
    List<Account> findAll();

}
