package com.apress.cems.beans.ci2;

import com.apress.cems.beans.ci.SimpleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanImpl2 implements SimpleBean {
    Logger logger = LoggerFactory.getLogger(SimpleBeanImpl2.class);

    public SimpleBeanImpl2(){
        logger.info("[SimpleBeanImpl-2 instantiation]");
    }

    @Override
    public String toString(){
        return "SimpleBeanImpl-2 { code: " + hashCode() + "}";
    }
}
