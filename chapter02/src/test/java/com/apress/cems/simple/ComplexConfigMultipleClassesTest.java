package com.apress.cems.simple;

import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.complex.ComplexConfigMultipleClasses;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ComplexConfigMultipleClassesTest {
    private Logger logger = LoggerFactory.getLogger(ComplexConfigMultipleClassesTest.class);
    private static final ApplicationContext ctx = new AnnotationConfigApplicationContext(ComplexConfigMultipleClasses.class);

    @Test
    void testSimpleConfigMultipleClasses(){
        for( String beanName : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + beanName);
        }
    }

    @Test
    void testSingletonConfigMultipleClasses(){
        SimpleBean simpleBean  = ctx.getBean("simpleBeanImpl", SimpleBean.class);
        assertNotNull(simpleBean);
        SimpleBean anotherBean = ctx.getBean("anotherSimpleBean",SimpleBean.class);
        assertNotNull(anotherBean);
        assertNotEquals(simpleBean.toString(),anotherBean.toString());
    }

}
