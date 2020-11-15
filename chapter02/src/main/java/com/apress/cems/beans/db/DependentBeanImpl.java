package com.apress.cems.beans.db;

import com.apress.cems.beans.ci.SimpleBean;

public class DependentBeanImpl implements DependentBean {
    private SimpleBean simpleBean;

    public DependentBeanImpl(SimpleBean simpleBean){
        this.simpleBean = simpleBean;
    }
}
