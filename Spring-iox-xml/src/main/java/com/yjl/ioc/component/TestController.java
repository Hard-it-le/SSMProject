package com.yjl.ioc.component;

/**
 * @author yujiale
 * @Classname TestController
 * @Description TOO
 * @Date 2021/9/25 下午6:02
 * @Created by yujiale
 */
public class TestController {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
