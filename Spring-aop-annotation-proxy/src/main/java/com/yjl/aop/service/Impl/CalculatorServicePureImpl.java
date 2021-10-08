package com.yjl.aop.service.Impl;

import com.yjl.aop.service.CalculatorService;
import org.springframework.stereotype.Component;

/**
 * @author yujiale
 * @Classname CalculatorPureImpl
 * @Description TOO
 * @Date 2021/9/26 下午9:50
 * @Created by yujiale
 */
@Component
public class CalculatorServicePureImpl implements CalculatorService {

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
