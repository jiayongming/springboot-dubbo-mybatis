package com.ymjia.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 1
 */
@Aspect
@Component
@Slf4j(topic = "time-statistic")
public class TimerLogger {

    @Around("execution(* com.ymjia.demo.application.service.impl.*.*(..)) " )
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        timeLog( "service",pjp.getSignature().getDeclaringTypeName(),pjp.getSignature().getName(),elapsedTime);

        return output;
    }

    @Around("execution(* com.ymjia.demo.application.mapper.*Mapper.*(..))")
    public Object profile2(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;

        timeLog( "mapper",pjp.getSignature().getDeclaringTypeName(),pjp.getSignature().getName(),elapsedTime);


        return output;
    }

    private void timeLog(String model, String className, String method, long elapsedTime) {
        log.info("{} : {} : {} : {}",model,className,method,elapsedTime);
    }
}
