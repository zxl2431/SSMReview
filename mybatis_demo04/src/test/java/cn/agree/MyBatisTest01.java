package cn.agree;

import cn.agree.domain.Account;
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

public class MyBatisTest01 {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;
    private UserMapper userMapper;
    private AccountMapper accountMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    /*
    *  一对一的延迟加载
    *
    * */
    @Test
    public void testFindAccounts() {
        List<Account> accounts = accountMapper.findAccounts();

        for (Account account : accounts) {
            System.out.println(account.getMoney()+"---"+account.getUser());
        }
    }

    /*
    *  一对多的延迟加载
    *
    * */
    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testFindAllUser() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /*
    * Mybatis的一级缓存
    * */
    @Test
    public void testCache1() {
        User user = sqlSession.selectOne("cn.agree.mapper.UserMapper.findByUserId", 1);
        sqlSession.clearCache();
        User user1 = sqlSession.selectOne("cn.agree.mapper.UserMapper.findByUserId", 1);
        System.out.println(user);
        System.out.println(user1);
    }

    /*
    *  MyBatis 二级缓存测试
    *
    * */
    @Test
    public void testCache2() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.findByUserId(1);
        System.out.println(user1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findByUserId(1);
        System.out.println(user2);

    }


    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }
}
