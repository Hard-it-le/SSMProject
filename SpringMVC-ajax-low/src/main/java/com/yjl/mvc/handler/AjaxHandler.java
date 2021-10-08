package com.yjl.mvc.handler;

import com.yjl.mvc.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yujiale
 */
@Controller
public class AjaxHandler {

    // 当返回响应体数据包含乱码时，在@RequestMapping注解中设置
    // produces属性给响应体设置内容类型
    @ResponseBody
    @RequestMapping(value = "/ajax/get/message", produces = "text/html;charset=UTF-8")
    public String getMessage() {
        return "message from server:你好";
    }

    // 如果返回 JSON 数据时遇到乱码问题，那么内容类型应设置为：application/json;charset=UTF-8
    // 这里需要注意：JSON 属于 application 这个大类，不属于 text
    @ResponseBody
    @RequestMapping(value = "/ajax/get/entity", produces = "application/json;charset=UTF-8")
    public Emp getEntity() {

        Emp emp = new Emp();

        emp.setEmpName("舔狗");

        return emp;
    }

}
