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

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    /*
    *  在执行Test之前执行
    *
    * */
    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            sqlSession = sqlSessionFactory.openSession();
            userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("黎明");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("香港");
        int i = userMapper.saveUser(user);
        System.out.println("新增User的id:"+user.getId());

    }

    /*
    *  修改用户
    * */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("郭富城");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("香港");
        user.setId(74);
        userMapper.updateUser(user);
        // System.out.println("新增User的id:"+user.getId());
    }

    /*
    *  删除用户
    * */
    @Test
    public void testDeleteUser() {
        userMapper.deleteUser(2);
    }

    /*
    *  模糊查询用户
    * */
    @Test
    public void testFindUserByUsername() {
        // String name = "%张%";
        String name = "%张%";
        List<User> users = userMapper.findUserByUsername(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /*
    * ognl表达式
    * 类中类的情况
    * */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("东方不败");
        vo.setUser(user);
        User userInfo = userMapper.findByVo(vo);
        System.out.println(userInfo);
    }

    /*
    *  查询总数
    * */
    @Test
    public void testFindUserCount() {
        int userCount = userMapper.findUserCount();
        System.out.println(userCount);
    }


    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }

}
