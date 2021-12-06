package com.spring.mvc.framework.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
public class DispatcherServlet extends HttpServlet {

    private Properties properties = new Properties();

    /**
     * 缓存扫描到的类的全限定类名
     */
    private List<String> classNameCaches = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件SpringMVC.properties
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);

        //2、扫描相关的类，扫描注解
        doScan(properties.getProperty("scanPackage"));
        //3、初始化bean对象（实现IOC容器，基于注解）
        doInstance();

        //4、 实现依赖注入
        doAutowired();

        //5、构造一个HandlerMapping构造器映射器，将配置好的url和methodName建立映射关系
        initHandlerMapping();
        System.out.println("SpringMVC初始化完成。。。。。。");
        //6、等待清楚进入，处理请求，初始化完成
    }

    /**
     * 构造一个HandlerMapping构造器映射器
     */
    private void initHandlerMapping() {
    }

    /**
     * 实现依赖注入
     */
    private void doAutowired() {
    }

    /**
     * 实现ioc容器
     * <p>
     * 基于classNameCache缓存类的全限定类名，以及反射技术完成对象创建和管理
     */
    private void doInstance() {
        if (classNameCaches.size() == 0) {
            return;
        }

        for (int i = 0; i < classNameCaches.size(); i++) {
            String className = classNameCaches.get(i);
        }

    }


    /**
     * 扫描类,扫描注解
     * scanPackage ----->磁盘上的文件夹（File)
     *
     * @param scanPackage
     */
    private void doScan(String scanPackage) {
        String scanPackagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + scanPackage.replaceAll("\\.", "/");

        File pack = new File(scanPackagePath);

        File[] files = pack.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                doScan(scanPackage + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = scanPackage + "." + file.getName().replaceAll(".class", "");
                classNameCaches.add(className);

            }
        }

    }

    /**
     * 加载配置文件
     *
     * @param contextConfigLocation
     */
    private void doLoadConfig(String contextConfigLocation) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
