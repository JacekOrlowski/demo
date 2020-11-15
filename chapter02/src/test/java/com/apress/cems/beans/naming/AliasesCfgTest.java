package com.apress.cems.beans.naming;

import com.apress.cems.beans.ci.SimpleBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class AliasesCfgTest {
    private Logger logger = LoggerFactory.getLogger(AliasesCfgTest.class);

    @Test
    void testSimpleBeans(){
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AliasesCfg.class);

        SimpleBean simpleBean = ctx.getBean("beanOne", SimpleBean.class);
        assertNotNull(simpleBean);
        assertTrue(simpleBean instanceof SimpleBean);

        SimpleBean simpleBean2 = ctx.getBean("beanTwo", SimpleBean.class);
        assertEquals(simpleBean2,simpleBean);

        //no bean names 'simpleBean'
        assertThrows(NoSuchBeanDefinitionException.class, ()->{
            ctx.getBean("simpleBean",SimpleBean.class);
        });

        ctx.close();
    }
}
