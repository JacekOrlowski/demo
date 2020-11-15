package com.apress.cems.beans.misc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiscAppCfg {

    @Bean
    SimpleSingleton simpleSingleton(){
        return SimpleSingleton.getInstance();
    }

    @Bean
    SimpleSingleton anotherSimpleSingleton(){
        return SimpleSingleton.getInstance();
    }
}
