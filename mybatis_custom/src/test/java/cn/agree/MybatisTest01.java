package cn.agree;

import cn.agree.domain.User;
import cn.agree.io.Resources;
import cn.agree.mapper.UserMapper;

import cn.agree.session.SqlSession;
import cn.agree.session.SqlSessionFactory;
import cn.agree.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisTest01 {

    @Test
    public void testFindAll() throws IOException {
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 构建一个SqlSessionFactory
        /*
        *  构建者模式
        *  通过SqlSessionBuilder对象构建一个SqlSessionFactory
        *  是将一个复杂的对象的构建过程分离出来,隐藏了复杂对象的创建过程
        *
        *
        *
        * */
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        System.out.println("获取的sqlSessionFactory的对象是:"+sqlSessionFactory);

        // Factory构建一个session
        /*
        *  工厂模式
        *  通过SqlSessionFactory构建一个SqlSession
        *  工厂模式是最常用的实例化对象模式了, 是用工厂方法代替new 操作的一种模式
        *  工厂模式能够降低耦合度
        *
        * */
        // 在这一步加载配置文件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession实现增删改查
        /*
        *  代理模式
        *  通过SqlSession实现增删改查
        *  构建一个UserMapper接口的代理对象 让代理对象完成增删改查
        *
        *
        *
        * */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("获取的代理对象userMapper:"+userMapper);
        userMapper.findAll();
        List<User> users = userMapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        // 关闭资源
        sqlSession.close();
        is.close();
    }
}
