package com.yjl.xml.service.Impl;

import com.yjl.xml.service.CalculationPureService;

/**
 * @author yujiale
 * @Classname CalculationPureServiceImpl
 * @Description TOO
 * @Date 2021/9/28 下午8:22
 * @Created by yujiale
 */
public class CalculationPureServiceImpl  implements CalculationPureService {
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
