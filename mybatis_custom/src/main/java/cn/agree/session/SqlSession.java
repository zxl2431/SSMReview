package cn.agree.session;

import cn.agree.mapper.UserMapper;

import java.util.List;

public interface SqlSession {

    /*
    *  给Dao接口创建代理对象
    *
    * */
    <T> T getMapper(Class<T> clazz);

    /*
    *  List查询
    *
    * */
    <T> List<T> list(String key);

    void close();
}
