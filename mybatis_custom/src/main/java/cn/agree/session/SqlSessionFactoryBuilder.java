package cn.agree.session;

import cn.agree.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /*
    *  读取并解析配置文件
    *  构建一个SqlSessionFactory对象
    *
    * */
    public SqlSessionFactory build(InputStream is) {
        // 创建一个SqlSessionFactory
        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();
        // 存储主配置文件
        sqlSessionFactory.setIs(is);

        return sqlSessionFactory;
    }

}
