package com.kamko.experements.itemapp.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    @Before("com.kamko.experements.itemapp.aspects.Pointcuts.pointcutForUpdateMethod()")
    public void beforeUpdateItemSecurityAdvice() {
        System.out.println("beforeUpdateItemSecurityAdvice: проверка прав пользователя");
    }

    @Before("com.kamko.experements.itemapp.aspects.Pointcuts.pointcutForAddMethod())")
    public void beforeAddItemSecurityAdvice() {
        System.out.println("beforeAddItemSecurityAdvice: проверка прав пользователя");
    }
}
