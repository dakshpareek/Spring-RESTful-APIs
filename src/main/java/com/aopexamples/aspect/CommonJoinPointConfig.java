package com.aopexamples.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.aopexamples.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.aopexamples.business.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("dataLayerExecution() && businessLayerExecution()")
    public void allLayerExecution(){}

    /*
    @Pointcut("bean(*dao*)")
    public void beanContainingDao(){}

    @Pointcut("within(com.in28minutes.spring.aop.springaop.data..*)")
    public void dataLayerExecutionWithWithin(){}
    */
    @Pointcut("@annotation(com.aopexamples.aspect.TrackTime)")
    public void trackTimeAnnotation(){}
}
