package cn.agree;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "cn.agree")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

    @Value("${dataSource.jdbcUrl}")
    private String jdbcurl;

    @Value("${dataSource.driverClass}")
    private String driverClass;

    @Value("${dataSource.user}")
    private String user;

    @Value("${dataSource.password}")
    private String password;

    /*
    *  创建数据源
    * */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl(jdbcurl);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setDriverClass(driverClass);

            return dataSource;
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
    }

    /*
    *  创建JdbcTemplate
    *
    * */
    @Bean(name="jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /*
    *  定义一个事务管理器
    * */
    @Bean(name = "txtManager")
    public DataSourceTransactionManager createTxtManager(DataSource dataSource) {
        DataSourceTransactionManager txtManager = new DataSourceTransactionManager();
        txtManager.setDataSource(dataSource);
        return txtManager;
    }

}
