package com.kamko.experements.aspects;

import com.kamko.experements.model.Item;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("com.kamko.experements.aspects.Pointcuts.pointcutForAddMethod()")
    public void beforeAddItemLoggingAdvice(JoinPoint joinPoint) {

        // получение информации о методе с помощью joinPoint
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());

        // получение аргументов указанных при вызове метода с помощью joinPoint
        if (methodSignature.getName().equals("add")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof String) {
                    System.out.println("Добавлен товар: " + obj);
                    break;
                }
            }
        }

        // техническое сообщение
        System.out.println("beforeAddItemLoggingAdvice: логирование попытки добавить товар");
    }

    @Before("com.kamko.experements.aspects.Pointcuts.pointcutForUpdateMethod()")
    public void beforeUpdateLoggingAdvice() {
        System.out.println("beforeUpdateLoggingAdvice: логирование попытки изменить товаров");
    }
}
