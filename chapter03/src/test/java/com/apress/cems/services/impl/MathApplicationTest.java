package com.apress.cems.services.impl;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {MockitoCfg.class})
public class MathApplicationTest {

    Logger logger = LoggerFactory.getLogger(MathApplication.class);

    @Autowired
    ApplicationContext ctx;

    //@Mock object that will be simulated
    @Mock
    CalculatorService calcService;

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication;

    @Test
    public void testAdd(){
        for( String name : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + name);
        }

        assertNotNull(mathApplication);

        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //test the add functionality with mock
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
    }
}
