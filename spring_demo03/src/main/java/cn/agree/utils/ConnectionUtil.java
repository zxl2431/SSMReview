package cn.agree.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component("connectionUtil")
public class ConnectionUtil {

    private ThreadLocal<Connection> t1= new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
    *  获取当前线程上绑定的连接
    * */
    public Connection getThreadConnection() {
        try {
            Connection conn = t1.get();
            if (conn == null) {
                // 从数据源中获取一个连接
                conn = dataSource.getConnection();
                t1.set(conn);
            }
            System.out.println(t1.get());
            return t1.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /*
    *  把连接和当前线程解绑
    * */
    public void remove() {
        t1.remove();
    }

}
