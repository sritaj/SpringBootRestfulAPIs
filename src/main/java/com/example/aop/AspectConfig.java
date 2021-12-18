package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

//    @Before(value = "execution(* com.example.controller.*.*(..))")
//    public void beforeAdvice(JoinPoint joinPoint){
//        logger.info("Inside - Before Advice");
//    }

//    @Before(value = "execution(* com.example.controller.*.*(..)) and args(Object)")
//    public void beforeAdviceWithOneParameter(JoinPoint joinPoint, Object object){
//        logger.info("Request = : " + object);
//    }
//
//    @After(value = "execution(* com.example.controller.*.*(..)) and args(Object)")
//    public void afterAdvice(JoinPoint joinPoint, Object object){
//        logger.info("Request = : " + object);
//    }
//
//    @AfterReturning(value = "execution(* com.example.controller.*.*(..)) and args(Object)", returning = "returningObject")
//    public void afterReturningAdvice(JoinPoint joinPoint, Object object, Object returningObject){
//        logger.info("Response = : " + returningObject);
//    }
//
//    @Around(value = "execution(* com.example.controller.*.*(..)) and args(Object)")
//    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Object object){
//        logger.info("Request = : " + object);
//
//        Object returningObject = null;
//        try{
//            returningObject = proceedingJoinPoint.proceed();
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
//        logger.info("Response = : " + returningObject);
//    }

}
