package com.example.demo2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.example.demo2.aop" })
class SpringContextAOP {
}

@Aspect
@Component
class MyAspect {
    @Before("execution(* com.example.demo2.aop.HiByeService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.print("Before ");
        System.out.print(joinPoint.getSignature().getName() + " called with ");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.example.demo2.aop.HiByeService.*(..))", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        System.out.print("After ");
        System.out.print(joinPoint.getSignature().getName());
        System.out.println(" result is " + result);
    }

}


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextAOP.class)
public class AOPExample{

    @Autowired
    private HiByeService service;

    @Test
    public void testSomething() {
        service.sayHi("AOP testing");
        service.sayBye();
        service.returnSomething();
    }
}



@Component
class HiByeService {
    public void sayHi(String name) {
        System.out.println("Hi " + name);
    }

    public void sayBye() {
        System.out.println("Bye");
    }

    public String returnSomething() {
        return "Hi Bye";
    }
}