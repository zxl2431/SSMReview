package cn.agree;

import cn.agree.domain.User;
import cn.agree.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        // Factory构建一个session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession实现增删改查
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        // 关闭资源
        sqlSession.close();
        is.close();
    }
}
