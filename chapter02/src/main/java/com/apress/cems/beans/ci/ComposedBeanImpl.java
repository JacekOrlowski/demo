package com.apress.cems.beans.ci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComposedBeanImpl implements ComposedBean{
    private SimpleBean simpleBean;

    @Autowired
    public ComposedBeanImpl(@Qualifier("anotherSimpleBean") SimpleBean simpleBean){
        this.simpleBean = simpleBean;
    }
}
