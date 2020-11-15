package com.apress.cems.beans.ci;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.apress.cems.beans.ci"})
public class SimpleAppCfg {
    @Bean
    SimpleBean anotherSimpleBean(){ // bean id=anotherSimpleBean
        return new SimpleBeanImpl();
    }
}
