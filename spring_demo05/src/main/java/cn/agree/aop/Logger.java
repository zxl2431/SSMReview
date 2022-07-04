package cn.agree.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component(value = "logger")
@Aspect
public class Logger {

    /****
     * 前置通知方法
     */
    @Before("execution(* cn.agree.service.impl.*.*(..))")
    public void printLog(){
        System.out.println("------------before--------");
    }

    /***
     * 后置通知
     * after-returning
     */
    @AfterReturning("execution(* cn.agree.service.impl.*.*(..))")
    public void afterLog(){
        System.out.println("----------afterReturning----------");
    }

    /***
     * after-throwing
     * 异常通知
     */
    @AfterThrowing("execution(* cn.agree.service.impl.*.*(..))")
    public void error(){
        System.out.println("--------after-throwing--------");
    }

    /***
     * after
     * 最终通知
     */
    @After("execution(* cn.agree.service.impl.*.*(..))")
    public void after(){
        System.out.println("---------after----------");
    }

}
