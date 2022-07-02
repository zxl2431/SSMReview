package cn.agree.mapper;

import cn.agree.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {

    /*
    *  查询所有账户
    *  实现一对一查询
    * */
    @Select(value = "select * from account1")
    @Results({
            @Result(property = "user", column = "uid",
                one = @One(select = "cn.agree.mapper.UserMapper.findByUserId",
                fetchType = FetchType.EAGER))
    })
    List<Account> findAll();


    /*
    *  根据Uid查询账户
    *
    * */
    @Select("select * from account1 where uid=#{uid}")
    List<Account> findAccountListByUid(Integer uid);


}
