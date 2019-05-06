package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

public class JdbcConfig {

    @Autowired
    private Environment env;

    @Bean("runner")
    @Scope("prototype")
    //会自动寻找DataSource类型实例.
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds=new ComboPooledDataSource();
        try {
            //为了不写死,需要从配置文件中读取
            ds.setDriverClass(env.getProperty("jdbc.driver"));
            ds.setJdbcUrl(env.getProperty("jdbc.url"));
            //此处的jdbcurl和xml配置的中不同,我服了
            ds.setUser(env.getProperty("jdbc.username"));
            ds.setPassword(env.getProperty("jdbc.password"));
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
