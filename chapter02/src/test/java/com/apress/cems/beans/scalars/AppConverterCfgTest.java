package com.apress.cems.beans.scalars;

import java.util.List;
import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.ci.SimpleBeanImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppConverterCfgTest {
    private final Logger logger = LoggerFactory.getLogger(AppConverterCfgTest.class);

    @Test
    void testSimpleBeans(){
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConvertersCfg.class);

        List<SimpleBean> simpleBean =  (List<SimpleBean>)ctx.getBean("simpleBeanList");
        assertNotNull(simpleBean);

        simpleBean.add(new SimpleBeanImpl());
        assertEquals( 1, simpleBean.size());

        for( String name : ctx.getBeanDefinitionNames()){
            logger.info("Bean " + name);
        }

        ctx.close();
    }
}
