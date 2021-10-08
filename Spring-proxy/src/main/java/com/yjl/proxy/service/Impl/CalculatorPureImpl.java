package com.yjl.proxy.service.Impl;

import com.yjl.proxy.service.Calculator;

/**
 * @author yujiale
 * @Classname CalculatorPureImpl
 * @Description TOO
 * @Date 2021/9/25 下午10:28
 * @Created by yujiale
 */
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {

        int result = i + j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;

        System.out.println("方法内部 result = " + result);

        return result;
    }
}
