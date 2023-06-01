package com.kamko.experements.itemapp.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("com.kamko.experements.itemapp.aspects.Pointcuts.pointcutForAddMethod()")
    public void beforeAddExceptionHandlingAdvice() {
        System.out.println("beforeAddExceptionHandlingAdvice: " +
                "поимка/обработка исключения при попытке добавить товар");
    }

    @AfterThrowing(pointcut = "com.kamko.experements.itemapp.aspects.Pointcuts.pointcutForAddMethod()",
            throwing = "exception")
    public void afterThrowingAddLoggingAdvice(Throwable exception) {
        System.out.println("Было поймано исключение: " + exception);
    }
    @Before("com.kamko.experements.itemapp.aspects.Pointcuts.pointcutForUpdateMethod()")
    public void beforeUpdateExceptionHandlingAdvice() {
        System.out.println("beforeUpdateExceptionHandlingAdvice: " +
                "поимка/обработка исключения при попытке изменить товар");
    }
}
