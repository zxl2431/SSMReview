package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtil connectionUtil;


    @Override
    public void save() {
        String sql = "select * from account where id=4";
        System.out.println("Dao已经执行...");
        try {
            Account account = queryRunner.query(sql, new BeanHandler<Account>(Account.class));
            System.out.println(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findByName(String name) {
        String sql = "select * from account where name=?";

        try {
            return queryRunner.query(connectionUtil.getThreadConnection(), sql, name, new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Account account) {
        String sql = "update account set balance=? where name=?";

        try {
            return queryRunner.update(connectionUtil.getThreadConnection(), sql, account.getBalance(), account.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
