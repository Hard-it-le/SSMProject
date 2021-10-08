package com.yjl.maven;

// 为了测试provided范围的依赖对main目录下的代码有效：
// provided范围的依赖：servlet-api
// main目录下的代码：HelloServlet

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 为了测试compile范围的依赖对main目录下的代码有效：
 * compile范围的依赖：pro01-maven-java
 * main目录下的代码：HelloServlet
 * 为了测试test范围的依赖对main目录下的代码无效
 * test范围的依赖：junit
 * test目录下的代码：HelloServlet
 * import org.junit.Test;
 * 报错信息：HelloServlet.java:[17,17] 程序包org.junit不存在
 **/
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        response.getWriter().write("hello maven web 210323");

    }

}