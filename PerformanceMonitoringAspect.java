package com.telusko.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    private static final Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable{
        long start=System.currentTimeMillis();
        Object obj=jp.proceed();
        long end=System.currentTimeMillis();

        logger.info("METHOD Execution time : " + (end-start) + "ms");

        return obj;
    }
}
