package cn.agree;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*
*  Spring配置类 相当于bean.xml文件
* */
@Configuration
@ComponentScan("cn.agree")
@Import({JdbcConfig.class})
public class SpringConfiguration {

    /*
    *  创建一个QueryRunner, b并存入spring容器中
    *
    * */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier(value = "dataSource")DataSource dataSource) {
        return new QueryRunner(dataSource);
    }


}
