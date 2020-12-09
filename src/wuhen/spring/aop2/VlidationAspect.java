package wuhen.spring.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// TODO: 2020/7/18 优先切面通知
@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("wuhen.spring.aop2.LoggingAspect.declareJointPointExpression()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate:" + Arrays.asList(joinPoint.getArgs()));
    }

}
