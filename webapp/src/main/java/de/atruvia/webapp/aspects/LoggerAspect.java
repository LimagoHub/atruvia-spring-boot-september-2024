package de.atruvia.webapp.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Before(value="execution(public * de.atruvia.webapp.presentation.v1.PersonenQueryController.*(..))")
    public void logAdvice(final JoinPoint joinPoint) {
        log.warn(String.format("############################# Before: %s ######################", joinPoint.getSignature().getName()));
    }
    @AfterReturning(value="execution(public * de.atruvia.webapp.presentation.v1.PersonenQueryController.*(..))", returning = "result")
    public void afterReturning(final JoinPoint joinPoint, Object result) {

        log.warn(String.format("############################# Afterreturning: %s ######################", joinPoint.getSignature().getName()));
        log.warn(String.format("############################# Result: %s ######################", result.toString()));
    }

    @AfterThrowing(value="execution(public * de.atruvia.webapp.presentation.v1.PersonenQueryController.*(..))", throwing = "ex")
    public void afterThrowing(final JoinPoint joinPoint, Object ex) {

        log.warn(String.format("############################# Afterreturning: %s ######################", joinPoint.getSignature().getName()));
        log.warn(String.format("############################# Result: %s ######################", result.toString()));
    }
}
