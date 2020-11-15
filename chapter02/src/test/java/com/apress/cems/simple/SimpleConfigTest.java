package com.apress.cems.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import com.apress.cems.beans.ci.SimpleBean;
import org.junit.jupiter.api.Assertions;
import com.apress.cems.beans.simple.SimpleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleConfigTest {
    private final Logger logger = LoggerFactory.getLogger(SimpleConfigTest.class);
    private static final  ApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleConfig.class);
    @Test
    void testSimpleConfiguration(){
        for( String beanName : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + beanName);
        }
    }

    @Test
    void testOneBeanConfiguration(){
        SimpleBean simpleBeanOne = ctx.getBean(SimpleBean.class);
        SimpleBean simpleBeanTwo = ctx.getBean(SimpleBean.class);
        Assertions.assertEquals(simpleBeanOne,simpleBeanTwo);
    }
}
