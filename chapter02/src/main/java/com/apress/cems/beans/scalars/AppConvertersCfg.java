package com.apress.cems.beans.scalars;

import com.apress.cems.beans.ci.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@ComponentScan(basePackages = {"com.apress.cems.beans.scalars"})
@Configuration
public class AppConvertersCfg {

    @Bean
    List<SimpleBean> simpleBeanList(){
        return new ArrayList<>();
    }

    @Bean
    public Set<SimpleBean> simpleBeanSet(){
        return new HashSet<>();
    }

    @Bean
    public Map<String,SimpleBean> simpleBeanMap(){
        return new HashMap<>();
    }
}
