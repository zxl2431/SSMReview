package cn.agree.mapper;

import cn.agree.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
   /* @Select("select * from user")
    @Results(id = "UserResultMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address")
    })
    List<User> findAll();*/

   /*
   *  查询所有
   * */
   @Select(value = "select * from user")
   @Results(
           @Result(column = "id", property = "accountList",
                   many = @Many(select = "cn.agree.mapper.AccountMapper.findAccountListByUid",
                   fetchType = FetchType.LAZY))
   )
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
