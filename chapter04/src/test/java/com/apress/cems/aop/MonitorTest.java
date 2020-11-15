package com.apress.cems.aop;

import org.slf4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AopConfig.class })
public class MonitorTest {
    Logger logger = LoggerFactory.getLogger(MonitorTest.class);

    @Autowired
    ApplicationContext ctx;

    @Autowired
    PersonRepo<String> personRepo;

    @Test
    public void testFindById(){
        for( String bean : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + bean);
        }
        Optional<String> optional = personRepo.findById(1L);
        assertEquals("Jacek Orłowski", optional.get());
    }
}
