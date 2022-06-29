package cn.agree.dao;

import cn.agree.domain.User;

import java.util.List;

public interface UserDao {

    /*
    * 根据ID查找
    * */
    User findByUserId(Integer id);

    /*
    * 根据姓名模糊查找
    * */
    List<User> findUserByUsername(String name);

    /*
    * 保存用户
    * */
    int saveUser(User user);

}
