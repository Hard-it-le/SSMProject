package com.yjl.xml.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;
import java.util.List;

/**
 * @author yujiale
 */
public class LogAspect {

    public void printLogBeforeCore(JoinPoint joinPoint) {

        // 1.通过JoinPoint对象获取目标方法签名对象
        // 方法的签名：一个方法的全部声明信息
        Signature signature = joinPoint.getSignature();

        // 2.通过方法的签名对象获取目标方法的详细信息
        String methodName = signature.getName();
        System.out.println("methodName = " + methodName);

        int modifiers = signature.getModifiers();
        System.out.println("modifiers = " + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName = " + declaringTypeName);

        // 3.通过JoinPoint对象获取外界调用目标方法时传入的实参列表
        Object[] args = joinPoint.getArgs();

        // 4.由于数组直接打印看不到具体数据，所以转换为List集合
        List<Object> argList = Arrays.asList(args);

        System.out.println("[AOP前置通知] " + methodName + "方法开始了，参数列表：" + argList);
    }

    public void printLogAfterCoreSuccess(JoinPoint joinPoint, Object targetMethodReturnValue) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP返回通知] "+methodName+"方法成功结束了，返回值是：" + targetMethodReturnValue);
    }

    public void printLogAfterCoreException(JoinPoint joinPoint, Throwable targetMethodException) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP异常通知] "+methodName+"方法抛异常了，异常类型是：" + targetMethodException.getClass().getName());
    }

    public void printLogCoreFinallyEnd(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP后置通知] "+methodName+"方法最终结束了");
    }

}
