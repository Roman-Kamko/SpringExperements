package com.kamko.experements.itemapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(public * com.kamko.experements.itemapp.service.ItemService.update(..))")
    public void pointcutForUpdateMethod(){}

    @Pointcut("execution(public * com.kamko.experements.itemapp.service.ItemService.add(..))")
    public void pointcutForAddMethod(){}
}
