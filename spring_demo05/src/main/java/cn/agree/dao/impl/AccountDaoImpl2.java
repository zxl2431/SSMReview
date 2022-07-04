package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.domain.AccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findAccountById(Integer id) {
        //getJdbcTemplate()方法是从父类上继承下来的。
        List<Account> list = getJdbcTemplate().query("select * from account where id = ? ",new AccountRowMapper(),id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        //getJdbcTemplate()方法是从父类上继承下来的。
        List<Account> list =  getJdbcTemplate().query("select * from account where name = ? ",new AccountRowMapper(),name);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果集不唯一，不是只有一个账户对象");
        }
        return list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        //getJdbcTemplate()方法是从父类上继承下来的。
        getJdbcTemplate().update("update account set money = ? where id = ? ",account.getBalance(), account.getId());
    }
}
