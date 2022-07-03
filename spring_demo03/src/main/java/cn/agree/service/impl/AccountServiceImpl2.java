package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import cn.agree.utils.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager txManager;


    @Override
    public void save() {

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 开启事务
            txManager.beginTransaction();
            System.out.println("事务开启");

            // 根据名字查询账户信息
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            System.out.println(source);

            // 转出账户减钱 转入账户价钱
            source.setBalance(source.getBalance()-money);
            target.setBalance(target.getBalance()+money);
            // 更新两个账户
            accountDao.update(source);
            // 出现了异常
            // int i=1/0;
            accountDao.update(target);

            txManager.commit();

        } catch (Exception e) {
            System.out.println("事务回滚");
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }

    }
}
