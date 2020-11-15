package com.apress.cems.beans.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SimpleSingleton {
    Logger logger = LoggerFactory.getLogger(SimpleSingleton.class);

    private static SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton(){
        logger.info(">> Creating singleton instance");
    }

    public static synchronized SimpleSingleton getInstance(){
        return instance;
    }

    @Override
    public String toString(){
        return "" + hashCode();
    }
}
