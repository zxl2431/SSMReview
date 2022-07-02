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

    private UserMapper userMapper;
    private AccountMapper accountMapper;

    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    private InputStream is;

    @Before
    public void init() throws IOException {
        is= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        accountMapper = sqlSession.getMapper(AccountMapper.class);

    }

    @Test
    public void testFindByUserId() {
        User user = userMapper.findByUserId(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserListByName() {
        List<User> users = userMapper.findUserListByName('张');
        for (User user : users) {
            System.out.println(user);
        }
    }

    /*
    *  查询所有用户
    * */
    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /*
    *  根据ID修改用户
    *
    * */
    @Test
    public void testUpdateUserByUserId() {
        User user = new User();
        user.setId(76);
        user.setUsername("朝廷心腹");
        user.setSex("男");
        userMapper.updateUserByUserId(user);
    }

    /*
    * 根据ID删除
    * */
    @Test
    public void testDeleteByUserId() {
        int i = userMapper.deleteByUserId(73);
    }

    @Test
    public void testFindCount() {
        int count = userMapper.findCount();
        System.out.println(count);
    }

    /*
    *  Account用户测试
    *
    * */
    @Test
    public void testAccountFindAll() {
        List<Account> accounts = accountMapper.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @After
    public void destory() throws IOException {
        // 事务提交
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
