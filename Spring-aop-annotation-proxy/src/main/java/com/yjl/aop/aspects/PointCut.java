package com.yjl.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointCut {

    @Pointcut(value = "execution(public int *..CalculatorService.sub(int,int))")
    public void atguiguGlobalPointCut(){}

    @Pointcut(value = "execution(* *..*Service.*(..))")
    public void atguiguSecondPointCut(){}

    @Pointcut(value = "execution(* *..*Service.*(..))")
    public void transactionPointCut(){}
}
