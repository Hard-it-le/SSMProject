package com.spring.mvc.framework.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件SpringMVC.properties

        //2、扫描相关的类，扫描注解

        //3、初始化bean对象（实现IOC容器，基于注解）

        //4、 实现依赖注入

        //5、构造一个HandlerMapping构造器映射器，将配置好的url和methodName建立映射关系

        System.out.println("SpringMVC初始化完成。。。。。。");
        //6、等待清楚进入，处理请求，初始化完成

        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
