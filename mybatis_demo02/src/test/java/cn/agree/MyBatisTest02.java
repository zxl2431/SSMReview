package cn.agree;

import cn.agree.dao.UserDao;
import cn.agree.dao.impl.UserDaoImpl;
import cn.agree.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest02 {
    private UserDao userDao;

    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            userDao = new UserDaoImpl(sqlSessionFactory);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByUserId() {
        User user = userDao.findByUserId(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() {
        List<User> users = userDao.findUserByUsername("%张%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        //创建User实例
        User user = new User();
        user.setUsername("毛阿敏");
        user.setAddress("香港");
        user.setBirthday(new Date());
        user.setSex("女");

        //调用添加方法保存数据
        int i = userDao.saveUser(user);
        System.out.println(i+"--"+user.getId());
    }

}
