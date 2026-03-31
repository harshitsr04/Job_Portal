package com.telusko.spring_boot_rest.aop;

import com.telusko.spring_boot_rest.model.LogEntitiy;
import com.telusko.spring_boot_rest.repo.LogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoggingAspect {

    @Autowired
    private LogEntitiy logEntitiy;

    @Autowired
    private LogRepository logRepository;

    private static final Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void longMethodCall(JoinPoint jp){
        logEntitiy.setMethodName(jp.getSignature().getName());
        logger.info("METHOD CALLED : " + jp.getSignature().getName());
        logEntitiy.setMethodMessage("METHOD CALLED");
        logEntitiy.setTimeStamp(LocalDateTime.now());

        logRepository.save(logEntitiy);
    }

    @After("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void MethodExecuted() {
        logger.info("METHOD Executed");
    }

    @AfterReturning("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void MethodExecutedSuccessfully() {
        logger.info("METHOD Executed Successfullly");
    }

    @AfterThrowing("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void MethodCrashed() {
        logger.info("METHOD Crashed");
    }

}
