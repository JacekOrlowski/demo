package com.apress.cems.beans.db;

import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.ci.SimpleBeanImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleDependentCfg {
    private Logger logger = LoggerFactory.getLogger(SimpleDependentCfg.class);

    @Bean
    SimpleBean simpleBean(){
        return new SimpleBeanImpl();
    }

    @Bean
    DependentBean dependentBean(){
        return new DependentBeanImpl(simpleBean()); //proxying
    }
}
