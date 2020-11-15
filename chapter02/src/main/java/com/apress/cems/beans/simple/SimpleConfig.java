
package com.apress.cems.beans.simple;

import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.ci.SimpleBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.apress.cems.beans.simple"})
@Configuration
public class SimpleConfig {

    @Bean
    SimpleBean simpleBean(){
        return new SimpleBeanImpl();
    }
}
