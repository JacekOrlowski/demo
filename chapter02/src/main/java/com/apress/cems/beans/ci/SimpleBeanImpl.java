package com.apress.cems.beans.ci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanImpl implements SimpleBean {
    private final Logger logger = LoggerFactory.getLogger(com.apress.cems.beans.ci.SimpleBeanImpl.class);

    private String val = "SimpleBeanImpl val";

    public SimpleBeanImpl(){
        logger.info("[SimpleBeanImpl instantiation]");
    }

    public String getVal() {
        return val;
    }

    @Override
    public String toString(){
        return "SimpleBeanImpl { code: " + hashCode() + "}";
    }
}
