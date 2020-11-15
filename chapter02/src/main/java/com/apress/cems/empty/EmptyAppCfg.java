package com.apress.cems.empty;

import com.apress.cems.beans.ci.SimpleBean;
import com.apress.cems.beans.ci.SimpleBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan( basePackages = {"com.apress.cems.beans.ci2"})
@Configuration
public class EmptyAppCfg {
}
