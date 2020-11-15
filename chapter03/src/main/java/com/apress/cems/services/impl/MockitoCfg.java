package com.apress.cems.services.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockitoCfg {
    @Bean
    MathApplication mathApplication(){
        return new MathApplication();
    }
}
