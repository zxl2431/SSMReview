package cn.agree.mapper;


import cn.agree.domain.User;

import java.util.List;


public interface UserMapper {
    /*
     *  查询所有
     *
     * */
    List<User> findAll();

    /*
     *  添加用户
     *
     * */
    int saveUser(User user);

    /*
    *  修改用户
    * */
    int updateUser(User user);

    /*
    *  删除用户
    * */
    int deleteUser(Integer id);

    /*
    *  模糊查询
    * */
    List<User> findUserByUsername(String username);

    /*
    *  根据用户名查询用户
    * */
    // User findByVo(QueryVo vo);

    /*
    *  查询总数
    * */
    int findUserCount();

    /*
    *  根据ID集合查询
    * */
    // List<User> findByRang(QueryVo queryVo);



    /*
    * 一对多
    * */
    List<User> findUserAccountList();





}





