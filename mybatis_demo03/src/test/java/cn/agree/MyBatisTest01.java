package cn.agree;

import cn.agree.domain.QueryVo;
import cn.agree.domain.User;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MyBatisTest01 {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testFindByVo() {
        User user = new User();
        user.setId(61);
        user.setUsername("王六");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        User user1 = userMapper.findByVo(queryVo);
        System.out.println(user1);
    }

    @Test
    public void testFindByRang() {
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(64);
        ids.add(66);
        ids.add(68);
        queryVo.setIds(ids);

        List<User> users = userMapper.findByRang(queryVo);

        for (User u : users) {
            System.out.println(u);
        }

    }

    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }

}
