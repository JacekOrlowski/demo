package com.apress.cems.config;

import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.ci.SimpleBeanImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db/test-datasource.properties")
public class ContextConfiguration {

    Logger logger = LoggerFactory.getLogger(ContextConfiguration.class);

    @Value("#{'X' + 'Y'}")              // SpEL not property expression
    private String driverClassName;
    @Value("#{simpleBean.getVal()}")    // SpEL bean method invocation
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Autowired
    Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    SimpleBean simpleBean (){
        return new SimpleBeanImpl();
    }

    @Override
    public String toString(){
        return "Data source property parameters:" +
                "[" + driverClassName + "] " +
                "[" + url + "] " +
                "[" + username + "] " +
                "[" + password +"]" +
                "[" + environment.getProperty("db.banner") +"]";
    }
}
