package cn.agree.session.defaults;

import cn.agree.mapper.UserMapper;
import cn.agree.session.Configuration;
import cn.agree.session.SqlSession;
import cn.agree.session.mapper.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultSqlSession implements SqlSession {

    // 把Configuration对象给DefaultSqlSession
    private Configuration cfg;

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }


    @Override
    public <T> T getMapper(Class<T> clazz) {
        /*
        *  参数:
        *   1. 被代理对象的类加载器
        *   2. 字节数组 让代理对象和被代理对象有相同的行为
        *   3.InvocationHandler
        *
        * */
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                });
    }

    @Override
    public <T> List<T> list(String key) {
        try {
            // 从Configuration中获取Mapper
            Mapper mapper = cfg.getMappers().get(key);

            // 获取Connection对象
            Connection connection = cfg.getConnection();

            // 获取sql语句
            String sql = mapper.getSql();

            // 获取PreparedStatment
            PreparedStatement stm = connection.prepareStatement(sql);

            // 执行查询
            ResultSet resultSet = stm.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {

    }

}
