package com.apress.cems.config;

import com.apress.cems.beans.ci.SimpleAppCfg;
import com.apress.cems.beans.ci.SimpleBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SimpleAppCfg.class})
public class ContextConfigurationTest {
    Logger logger = LoggerFactory.getLogger(ContextConfigurationTest.class);

    @Autowired
    ApplicationContext ctx;

    @Autowired
    @Qualifier("simpleBeanImpl")        // more than 1 bean of the type SimpleBean is present in ctx
    SimpleBean simpleBean;

    @Test
    void test(){
        assertNotNull(ctx);
        assertNotNull(simpleBean);
        for( String name : ctx.getBeanDefinitionNames() ){
            logger.info("Bean " + name);
        }
    }

}
