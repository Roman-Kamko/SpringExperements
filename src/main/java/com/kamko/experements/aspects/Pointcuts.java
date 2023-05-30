package com.kamko.experements.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class Pointcuts {
    @Pointcut("execution(public * com.kamko.experements.service.ItemService.update(..))")
    public void pointcutForUpdateMethod(){}

    @Pointcut("execution(public * com.kamko.experements.service.ItemService.add(..))")
    public void pointcutForAddMethod(){}
}
