package cn.agree;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig {

    /*
    *  创建一个数据源, 并存入spring容器中
    * */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setUser("root");
            ds.setPassword("root");
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db1");
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return null;
    }
}
