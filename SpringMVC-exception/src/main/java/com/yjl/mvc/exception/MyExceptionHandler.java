package com.yjl.mvc.exception;

import com.yjl.mvc.util.MVCUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 异常处理器类需要使用 @ControllerAdvice 注解标记
@ControllerAdvice
public class MyExceptionHandler {

    // @ExceptionHandler注解：标记异常处理方法
    // value属性：指定匹配的异常类型
    // 异常类型的形参：SpringMVC 捕获到的异常对象
    @ExceptionHandler(value = NullPointerException.class)
    public String resolveNullPointerException(Exception e, Model model) {

        // 我们可以自己手动将异常对象存入模型
        model.addAttribute("atguiguException", e);

        // 返回逻辑视图名称
        return "error-nullpointer";
    }

    @ExceptionHandler(value = Exception.class)
    public String resolveException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 调用工具方法判断当前请求是否是 Ajax 请求
        boolean judgeResult = MVCUtil.judgeRequestType(request);

        if (judgeResult) {

            // 对 Ajax 请求返回字符串作为响应体
            String message = e.getMessage();

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(message);

            // 上面已经使用原生 response 对象返回了响应，这里就不返回视图名称了
            return null;
        }

        // 对普通请求返回逻辑视图名称
        return "error-exception";
    }

}
