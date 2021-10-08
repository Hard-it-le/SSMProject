package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yujiale
 */
@Controller
public class Demo06DispatchHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test/forward/command")
    public String forwardCommand() {
        // 需求：要转发前往的目标地址不在视图前缀指定的范围内，
        // 通过返回逻辑视图、拼接前缀后缀得到的物理视图无法达到目标地址
        // 转发到指定的地址：
        return "forward:/outter.html";
    }

    @RequestMapping("/test/redirect/command")
    public String redirectCommand() {

        // 重定向到指定的地址：
        // 这个地址由 SpringMVC 框架负责在前面附加 contextPath，所以我们不能加，我们加了就加多了
        // 框架增加 contextPath 后：/demo/outter.html
        // 我们多加一个：/demo/demo/outter.html
        return "redirect:/outter.html";
    }
}
