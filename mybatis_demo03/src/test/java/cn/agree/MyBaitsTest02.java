package cn.agree;

import cn.agree.domain.Account;
import cn.agree.domain.AccountCustomer;
import cn.agree.domain.User;
import cn.agree.mapper.AccountMapper;
import cn.agree.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBaitsTest02 {

    private SqlSession sqlSession;
    private UserMapper userMapper;
    private AccountMapper accountMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Test
    public void testFindAccountList() {
        List<AccountCustomer> accountList = accountMapper.findAccountList();
        for (AccountCustomer customer : accountList) {
            System.out.println(customer);
        }
    }

    @Test
    public void testFindAccountList2() {
        List<Account> accountList2 = accountMapper.findAccountList2();
        for (Account account : accountList2) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindUserAccountList() {
        List<User> users = userMapper.findUserAccountList();
        for (User user: users) {
            System.out.println(user);
        }
    }


    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }

}
