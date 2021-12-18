package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Before(value = "execution(* com.example.controller.*.*(..)) and args(Object)")
    public void beforeAdviceWithOneParameter(JoinPoint joinPoint, Object object){
        logger.info("Request = : " + object);
    }


}
