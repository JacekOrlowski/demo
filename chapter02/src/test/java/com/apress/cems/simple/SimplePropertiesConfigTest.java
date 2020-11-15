package com.apress.cems.simple;


import com.apress.cems.config.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimplePropertiesConfigTest {
    private Logger logger = LoggerFactory.getLogger(SimplePropertiesConfigTest.class);
    private static final ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextConfiguration.class);

    @Test
    void testPropertiesInitialization(){
        for( String beanName : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + beanName);
        }
        ContextConfiguration testPropertiesConfig = ctx.getBean(ContextConfiguration.class);
        logger.info( testPropertiesConfig.toString() );
    }


}
