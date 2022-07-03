package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    // 操作数据库的 具体怎么操作的忘了
    // 类似的还有一个jdbctemplate
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public void saveAccount(Account account) {
        String sql = "insert into account(name, balance) values(?,?)";
        try {
            runner.update(sql, account.getName(), account.getBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name=?, balance=? where id=?";
        try {
            runner.update(sql, account.getName(),account.getBalance(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer accountId) {
        String sql = "delete from account where id=?";
        try {
            runner.update(sql, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findById(Integer accountId) {
        String sql = "select * from account where id=?";

        try {
            return runner.query(sql, new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        try {
            return runner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   /* @Override
    public void saveAccount() {
        System.out.println("持久层保存了账户!");
    }*/


}
