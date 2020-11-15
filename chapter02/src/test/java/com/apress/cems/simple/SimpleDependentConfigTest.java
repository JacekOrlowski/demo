package com.apress.cems.simple;

import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.db.SimpleDependentCfg;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleDependentConfigTest {

    @Test
    void dependentConfigTest(){
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleDependentCfg.class);
        ctx.registerShutdownHook();

        SimpleDependentCfg simpleDependentCfg = ctx.getBean(SimpleDependentCfg.class);
        assertNotNull(simpleDependentCfg);

        SimpleBean simpleBean = ctx.getBean(SimpleBean.class);
        assertNotNull(simpleBean);
    }
}
