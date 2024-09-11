package de.atruvia.webapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut(value="execution(public * de.atruvia.webapp.presentation.v1.PersonenQueryController.*(..))")
    public void personenQueryControllerMethods(){}
}
