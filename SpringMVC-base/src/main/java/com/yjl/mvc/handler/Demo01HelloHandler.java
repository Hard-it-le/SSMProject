package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yujiale
 */
@Controller
public class Demo01HelloHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @RequestMapping注解在请求地址和Java方法之间建立映射关系
    // 方法返回的字符串会被直接拿来作为逻辑视图名称
    @RequestMapping("/")
    public String showPortal() {
        return "portal";
    }

    // 以后我们会越来越倾向于用一句话来作为请求的URL地址
    // 在这样的一句话中使用“/”分隔各个单词
    @RequestMapping("/say/hello/to/spring/mvc")
    public String sayHello() {

        // 方法内部打印日志，证明 SpringMVC 确实调用了这个方法来处理请求
        logger.debug("我是 SpringMVC 的 Hello world。");

        return "target";
    }

    @RequestMapping("/fruit/*")
    public String testUrlMatching() {

        logger.debug("测试@RequestMapping注解模糊匹配");

        return "target";
    }

}
