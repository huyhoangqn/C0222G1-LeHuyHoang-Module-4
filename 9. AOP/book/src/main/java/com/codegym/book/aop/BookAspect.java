package com.codegym.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning("execution(* com.codegym.book.controller.BookController.*(..))")
    public void afterReturn(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.error("tên phương thức: " + nameMethod);
        logger.error("tham số: " + args);
    }
}
