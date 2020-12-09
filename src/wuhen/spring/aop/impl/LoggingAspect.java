package wuhen.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// TODO: 2020/7/17  AOP切面编程  日志切面
//把这个类声明为一个切面：需要把该类放入到IOC容器中(@Component)，再声明为一个切面(@Aspect)
@Aspect
@Component
public class LoggingAspect {

    //声明该方法是一个前置通知：在所有目标方法开始之前执行
    @Before("execution(* wuhen.spring.aop.impl.*.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    //后置通知：在目标方法执行后（无论是否发生异常），都会执行的通知
    //在后置通知中还不能访问目标方法执行的结果
    @After("execution(* wuhen.spring.aop.impl.*.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends ");
    }
}
