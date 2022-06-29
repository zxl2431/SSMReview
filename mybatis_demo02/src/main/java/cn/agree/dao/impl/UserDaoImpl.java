package cn.agree.dao.impl;

import cn.agree.dao.UserDao;
import cn.agree.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    /*
    *
    * */
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findByUserId(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("cn.agree.mapper.UserMapper.findByUserId", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByUsername(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("cn.agree.mapper.UserMapper.findUserByUsername", name);
        sqlSession.close();

        return users;
    }

    @Override
    public int saveUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int num = sqlSession.insert("cn.agree.mapper.UserMapper.saveUser", user);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
