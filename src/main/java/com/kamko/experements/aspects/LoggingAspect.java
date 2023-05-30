package com.kamko.experements.aspects;

import com.kamko.experements.model.Item;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @AfterReturning(
            pointcut = "com.kamko.experements.aspects.Pointcuts.pointcutForAddMethod()",
            returning = "item")
    public void afterReturningAddItemLoggingAdvice(JoinPoint joinPoint, Item item) {
//        // получение информации о методе с помощью joinPoint(для практики)
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("methodSignature: " + methodSignature);
//        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
//        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
//        System.out.println("methodSignature.getName(): " + methodSignature.getName());

        // лог о добавленном товаре
        Item itemCopy = item;
        System.out.println("Добавлен товар: " + itemCopy.getName() +
                "; Стоимость: " + itemCopy.getPrice() +
                "; Количество: " + itemCopy.getAmount());
    }

    @Before("com.kamko.experements.aspects.Pointcuts.pointcutForAddMethod()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        for (Object obj : arguments) {
            if (obj instanceof String) {
                System.out.println("beforeAddItemLoggingAdvice: логирование, попытка добавить товар: " + obj);
                break;
            }
        }
    }

    @Before("com.kamko.experements.aspects.Pointcuts.pointcutForUpdateMethod()")
    public void beforeUpdateLoggingAdvice() {
        // техническое сообщение
        System.out.println("beforeUpdateLoggingAdvice: логирование, попытка изменить товаров");
    }
}
