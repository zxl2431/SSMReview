package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.domain.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from account where id=?";
        List<Account> accounts = jdbcTemplate.query(sql, new AccountRowMapper(), id);
        return accounts.isEmpty()?null:accounts.get(0);
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
        jdbcTemplate.update("update account set money = ? where id = ? ",account.getBalance(),account.getId());
    }
}
