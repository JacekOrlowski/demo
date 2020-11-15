package com.apress.cems.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.apress.cems.aop"})
@EnableAspectJAutoProxy
public class AopConfig {
}
