package cn.agree.session.defaults;

import cn.agree.session.Configuration;
import cn.agree.session.SqlSession;
import cn.agree.session.SqlSessionFactory;
import cn.agree.session.utils.XMLConfigBuilder;

import java.io.InputStream;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    // SqlMapConfig.xml的字节输入流
    private InputStream is;

    public void setIs(InputStream is) {
        this.is = is;
    }

    @Override
    public SqlSession openSession() {
        // 创建一个DefaultSqlSession
        DefaultSqlSession sqlSession = new DefaultSqlSession();

        // 加载配置文件
        Configuration cfg = XMLConfigBuilder.loadConfiguration(is);

        System.out.println("---openSession()中的cfg:"+cfg);

        sqlSession.setCfg(cfg);

        return sqlSession;
    }
}

