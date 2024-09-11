package de.atruvia.webapp.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
//@Profile("dev")
public class LoggerAspect {



    @Before(value="Pointcuts.personenQueryControllerMethods()")
    public void logAdvice(final JoinPoint joinPoint) {
        log.warn(String.format("############################# Before: %s ######################", joinPoint.getSignature().getName()));
    }
    @AfterReturning(value="Pointcuts.personenQueryControllerMethods()", returning = "result")
    public void afterReturning(final JoinPoint joinPoint, Object result) {

        log.warn(String.format("############################# Afterreturning: %s ######################", joinPoint.getSignature().getName()));
        log.warn(String.format("############################# Result: %s ######################", result.toString()));
    }

    @AfterThrowing(value="execution(public * de.atruvia.webapp.presentation.v1.PersonenQueryController.*(..))", throwing = "ex")
    public void afterThrowing(final JoinPoint joinPoint, Object ex) {

        log.warn(String.format("############################# Afterreturning: %s ######################", joinPoint.getSignature().getName()));
        log.warn(String.format("############################# Result: %s ######################", ex.toString()));
    }

    @Around(value="execution(public * de.atruvia.webapp.presentation.v1.PersonenQueryController.*(..))")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable{
        var start = Instant.now();
        var result = joinPoint.proceed();
        var end = Instant.now();
        var duration = Duration.between(start, end);
        log.warn(String.format("############################# Result: %s ######################",duration.toMillis()));
        return result;
    }
}
