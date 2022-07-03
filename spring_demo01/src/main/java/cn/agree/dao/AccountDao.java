package cn.agree.dao;

import cn.agree.domain.Account;

import java.util.List;

public interface AccountDao {

    /*
    *  模拟保存账户
    * */
    void saveAccount(Account account);

    /*
    *  更新
    * */
    void update(Account account);

    /*
    *  删除
    * */
    void delete(Integer accountId);

    /*
    * 根据ID查询
    * */
    Account findById(Integer accountId);

    /*
    *  查询所有
    * */
    List<Account> findAll();

}
