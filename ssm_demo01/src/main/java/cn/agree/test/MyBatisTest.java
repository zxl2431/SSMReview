package cn.agree.test;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    @Test
    public void testMyBaits() throws IOException {
        // 获取SqlMapConfig.xml 字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取SqlSessionFactoryBuider
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        sqlSession.close();


    }


}
