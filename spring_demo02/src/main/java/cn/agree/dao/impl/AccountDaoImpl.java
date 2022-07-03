package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;


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
}
