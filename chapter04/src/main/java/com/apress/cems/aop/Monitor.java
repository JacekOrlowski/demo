package com.apress.cems.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Monitor {
    private static final Logger logger = LoggerFactory.getLogger(Monitor.class);

    @Before(value = "execution(public * com.apress.cems.aop.JdbcPersonRepo+.findById(..))")
    public void beforeFindById(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + methodName + " is about to be called");
    }

    @Around("execution(public * com.apress.cems.aop.JdbcPersonRepo.findById(..))")
    public Object aroundFindById(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + methodName + " entering");
        Object result = joinPoint.proceed();
        logger.info(" ---> Method " + methodName + " exiting");
        return result;
    }

    @Pointcut("execution(public * com.apress.cems.aop.JdbcPersonRepo+.findById(..))")  // pointcut definition
    void pointcutDef(){}    // pointcut

    @After("pointcutDef()")
    public void afterFindById(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + methodName + " is about to be exited");
    }
}
