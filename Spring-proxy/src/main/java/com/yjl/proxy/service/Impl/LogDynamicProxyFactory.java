package com.yjl.proxy.service.Impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * @author yujiale
 * @Classname CalculatorDynamicProxy
 * @Description TOO
 * @Date 2021/9/26 下午7:30
 * @Created by yujiale
 */
public class LogDynamicProxyFactory<T> {

    /**
     * 将被代理的目标对象声明为成员变量
     */
    private T target;

    public LogDynamicProxyFactory(T target) {
        this.target = target;
    }

    public T getProxy() {
        // 创建代理对象所需参数一：加载目标对象的类的类加载器
        // 创建代理对象所需参数二：目标对象的类所实现的所有接口组成的数组
        // 创建代理对象所需参数三：InvocationHandler对象
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        /** Lambda表达式口诀：
         // 1、复制小括号
         // 2、写死右箭头
         // 3、落地大括号
         **/
        InvocationHandler handler = (
                // 代理对象，当前方法用不上这个对象
                Object proxy,
                //method代表目标放的method对象
                Method method,
                // 外部调用目标方法时传入的实际参数
                Object[] args) -> {
            // 通过method对象获取方法名
            String methodName = method.getName();
            // 我们对InvocationHandler接口中invoke()方法的实现就是在调用目标方法
            // 围绕目标方法的调用，就可以添加我们的附加功能
            //声明一个局部比纳凉，用来存储目标方法的返回值
            Object targetMethodReturnValue = null;
            // 为了便于在打印时看到数组中的数据，把参数数组转换为List
            List<Object> argumentList = Arrays.asList(args);

            try {
                System.out.println("[动态代理][日志] " + methodName + " 方法开始了，参数是：" + argumentList);
                // 调用目标方法：需要传入两个参数
                // 参数1：调用目标方法的目标对象
                // 参数2：外部调用目标方法时传入的实际参数
                // 调用后会返回目标方法的返回值
                targetMethodReturnValue = method.invoke(target, args);
                // 在目标方法成功后：打印方法成功结束的日志【寿终正寝】
                System.out.println("[动态代理][日志] " + methodName + " 方法成功结束了，返回值是：" + targetMethodReturnValue);
            } catch (Exception e) {
                // 通过e对象获取异常类型的全类名
                String exceptionName = e.getClass().getName();

                // 通过e对象获取异常消息
                String message = e.getMessage();
                // 在目标方法成功后：打印方法成功失败的日志
                System.out.println("[动态代理][日志] " + methodName + " 方法抛异常了，异常信息是：" + exceptionName + "," + message);
            } finally {
                // 在目标方法成功后：打印方法成功最终的日志
                System.out.println("[动态代理][日志] " + methodName + " 方法最终结束了");

            }
            // 这里必须将目标方法的返回值返回给外界，如果没有返回，外界将无法拿到目标方法的返回值
            return targetMethodReturnValue;
        };

        T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
        return proxy;
    }

    public void setTarget(T target) {
        this.target = target;
    }

}
