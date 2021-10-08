package com.yjl.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// 使用@Aspect注解把当前类标记为切面类
@Aspect

// 切面类也必须加入IOC容器才能够生效
@Component

@Order(2) // @Order注解控制当前切面的优先级，数值越小优先级越高
public class LogAspect {

    // 在一个专门的方法上，使用@Pointcut声明的切入点表达式可以被各个通知方法引用
    // 实现『一处修改处处生效』的效果
    @Pointcut(value = "execution(public int com.yjl.aop.service.CalculatorService.mul(int,int))")
    public void atguiguPointCut() {
    }

    // 如果想引用其它类声明的切入点表达式，那么在方法名前面加上全类名即可
    @Before(value = "com.yjl.aop.aspects.PointCut.atguiguSecondPointCut()")
    //在通知方法中可以通过方法名来引用公共的切入点表达式
    //@Before(value = "PointCut()")
    // @Before注解标记前置通知方法
    // value属性：切入点表达式，告诉Spring当前通知方法要套用到哪个目标方法上
    // 在前置通知方法形参位置声明一个JoinPoint类型的参数，Spring就会将这个对象传入
    // 根据JoinPoint对象就可以获取目标方法名称、实际参数列表
    // @Before(value = "execution(* *..*Service.*Soldier(Integer, ..)) || execution(* *..Calculator.*(..))")
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

    // @AfterReturning注解标记返回通知方法
    // 在返回通知中获取目标方法返回值分两步：
    // 第一步：在@AfterReturning注解中通过returning属性设置一个名称
    // 第二步：使用returning属性设置的名称在通知方法中声明一个对应的形参
    @AfterReturning(
            value = "com.yjl.aop.aspects.PointCut.atguiguSecondPointCut()",
            returning = "targetMethodReturnValue"
    )
    public void printLogAfterCoreSuccess(JoinPoint joinPoint, Object targetMethodReturnValue) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP返回通知] " + methodName + "方法成功结束了，返回值是：" + targetMethodReturnValue);
    }

    // @AfterThrowing注解标记异常通知方法
    // 在异常通知中获取目标方法抛出的异常分两步：
    // 第一步：在@AfterThrowing注解中声明一个throwing属性设定形参名称
    // 第二步：使用throwing属性指定的名称在通知方法声明形参，Spring会将目标方法抛出的异常对象从这里传给我们
    @AfterThrowing(
            value = "com.yjl.aop.aspects.PointCut.atguiguSecondPointCut()",
            throwing = "targetMethodException"
    )
    public void printLogAfterCoreException(JoinPoint joinPoint, Throwable targetMethodException) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP异常通知] " + methodName + "方法抛异常了，异常类型是：" + targetMethodException.getClass().getName());
    }

    // @After注解标记后置通知方法
    @After(value = "com.yjl.aop.aspects.PointCut.atguiguSecondPointCut()")
    public void printLogCoreFinallyEnd(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP后置通知] " + methodName + "方法最终结束了");
    }

}
