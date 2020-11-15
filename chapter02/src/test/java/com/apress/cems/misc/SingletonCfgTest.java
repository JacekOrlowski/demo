package com.apress.cems.misc;

import com.apress.cems.beans.misc.MiscAppCfg;
import com.apress.cems.beans.misc.SimpleSingleton;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SingletonCfgTest {
    private Logger logger = LoggerFactory.getLogger(SingletonCfgTest.class);

    @Test
    void singletonTest(){
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MiscAppCfg.class);
        SimpleSingleton simpleSingleton = ctx.getBean("simpleSingleton", SimpleSingleton.class);
        assertNotNull(simpleSingleton);
        SimpleSingleton anotherSimpleSingleton = ctx.getBean("anotherSimpleSingleton", SimpleSingleton.class);
        assertNotNull(anotherSimpleSingleton);
        assertEquals(simpleSingleton, anotherSimpleSingleton);

        for(String name : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + name);
        }
        ctx.close();
    }
}
