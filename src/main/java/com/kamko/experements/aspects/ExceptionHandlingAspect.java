package com.kamko.experements.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("com.kamko.experements.aspects.Pointcuts.pointcutForAddMethod()")
    public void beforeAddExceptionHandlingAdvice() {
        System.out.println("beforeAddExceptionHandlingAdvice: " +
                "поимка/обработка исключения при попытке добавить товар");
    }
    @Before("com.kamko.experements.aspects.Pointcuts.pointcutForUpdateMethod()")
    public void beforeUpdateExceptionHandlingAdvice() {
        System.out.println("beforeUpdateExceptionHandlingAdvice: " +
                "поимка/обработка исключения при попытке изменить товар");
    }
}