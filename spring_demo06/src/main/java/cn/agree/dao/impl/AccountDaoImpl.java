package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.domain.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ? ",new AccountRowMapper(),id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list =  jdbcTemplate.query("select * from account where name = ? ",new AccountRowMapper(),name);
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
        jdbcTemplate.update("update account set balance = ? where id = ? ",account.getBalance(), account.getId());
    }
}
