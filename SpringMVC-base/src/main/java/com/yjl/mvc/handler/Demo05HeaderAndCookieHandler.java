package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author yujiale
 */
@Controller
public class Demo05HeaderAndCookieHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/request/header")
    public String getRequestHeader(
            // 使用 @RequestHeader 注解获取请求消息头信息
            // name 或 value 属性：指定请求消息头名称
            // defaultValue 属性：设置默认值
            @RequestHeader(name = "Accept", defaultValue = "missing") String accept
    ) {

        logger.debug("accept = " + accept);

        return "target";
    }

    @RequestMapping("/request/cookie")
    public String getCookie(
            // 使用 @CookieValue 注解获取指定名称的 Cookie 数据
            // name 或 value 属性：指定Cookie 名称
            // defaultValue 属性：设置默认值
            @CookieValue(value = "JSESSIONID", defaultValue = "missing") String cookieValue,
            // 形参位置声明 HttpSession 类型的参数即可获取 HttpSession 对象
            HttpSession session
    ) {
        logger.debug("cookieValue = " + cookieValue);
        return "target";
    }
}
