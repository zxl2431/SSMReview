package cn.agree.mapper;

import cn.agree.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    /*
    *  根据ID查询
    * */
    @Select("select * from user where id=#{userid}")
    User findByUserId(Integer userid);

    /*
    *  根据名字模糊查询
    * */
    @Select(value = "select * from user where username like '%${value}%'")
    List<User> findUserListByName(char name);

    /*
    *  查询所有
    * */
    @Select("select * from user")
    List<User> findAll();

    /*
    * 根据ID修改用户信息
    * */
    @Update("update user set username=#{username}, sex=#{sex} where id=#{id}")
    int updateUserByUserId(User user);

    /*
    * 根据ID删除
    * */
    @Delete("delete from user where id=#{id}")
    int deleteByUserId(int i);

    /*
    *  查询数据条数
    * */
    @Select("select count(*) from user")
    int findCount();


}
