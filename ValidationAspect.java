package com.telusko.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..)) && args(postID)")
    public Object validateOrUpdate(ProceedingJoinPoint jp,int postID) throws Throwable{

        if(postID<0){
            postID=-postID;
            logger.info("Validating the input value : " + postID);
        }
        Object obj=jp.proceed(new Object[]{postID}); //this giving new object array inside which giving the postid defines that now it is the updated value user has input -3 but here i have updated it to 3 and now this correct updated value is going to the method of jobservice not the input -3 which is coming from user preventing from thorwing error
        return obj;

    }
}
