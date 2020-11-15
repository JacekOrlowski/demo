package com.apress.cems.impl.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.sql.Driver;

class h2Exception extends RuntimeException{}

@Configuration
@PropertySource("classpath:connection.properties")
public class JdbcDbConfig2 {

    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.populate}")
    private Boolean populate;

    @Bean
    public JdbcTemplate jdbTemplate() throws ClassNotFoundException {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource(){
        try {
            var dataSource = new SimpleDriverDataSource();
            Class<? extends Driver> driver =(Class<? extends Driver>)Class.forName(driverClassName);
            dataSource.setDriverClass(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            if( populate ) {
                DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
            }
            return dataSource;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Value("classpath:db/schema.sql")
    private Resource schemaScript;

    @Value("classpath:db/test-data.sql")
    private Resource dataScript;

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        populator.addScript(dataScript);
        return populator;
    }

}
