package cn.agree.session;

import cn.agree.session.mapper.Mapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    // 数据库驱动
    private String driver;
    // 数据库连接地址
    private String url;
    // 数据库用户名
    private String username;
    // 数据库密码
    private String password;

    // 创建数据源
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 存储所有解析的Mapper
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    /*
    *  第一次set值的时候, 往Map中添加
    *  第N次set值的时候,也是往Map中添加
    * */
    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }


    public Configuration() {
    }

    public Configuration(String driver, String url, String username, String password, ComboPooledDataSource dataSource) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.dataSource = dataSource;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataSource=" + dataSource +
                ", mappers=" + mappers +
                '}';
    }

    /*
    *  使的Configuration对象具有获取数据库连接的能力
    *  创建数据库连接池
    * */
    public DataSource getDataSource() {
        try {
            dataSource.setDriverClass(this.driver);
            dataSource.setJdbcUrl(this.url);
            dataSource.setUser(this.username);
            dataSource.setPassword(this.password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    /*
    *  获取数据库连接对象
    *
    * */
    public Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
