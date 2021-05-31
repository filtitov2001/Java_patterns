package com.application.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeAspect {
    @Around(value = "@annotation(com.application.annotations.LogTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeStart = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeWork = System.currentTimeMillis() - timeStart;

        log.info(joinPoint.getSignature() + " сработало за " + timeWork + "мс");

        return proceed;
    }
}