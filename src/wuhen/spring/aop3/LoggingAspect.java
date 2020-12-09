package wuhen.spring.aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint){
        String methodeName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();

        System.out.println("The method " + methodeName + " begins with " + Arrays.asList(args));
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodeName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodeName + " ends");
    }

    public void afterReturning(JoinPoint joinPoint,Object object){
        String methodeName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodeName + " ends with " + object);
    }

    public void afterThrowing(JoinPoint joinPoint, Exception e){
        String methodeName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodeName + " occurs excetion: " + e);
    }


    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程:ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     */

    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        //System.out.println("aroundMethod:");

        Object result; // 为null
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method " + methodName +" ends");

        return result;
    }

}
