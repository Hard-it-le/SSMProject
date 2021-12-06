package com.spring.mvc.framework.servlet;

import com.spring.mvc.demo.controller.DemoController;
import com.spring.mvc.framework.annotations.TestController;
import com.spring.mvc.framework.annotations.TestService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    /**
     * ioc容器
     */
    private Map<String, Object> ioc = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件SpringMVC.properties
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);

        //2、扫描相关的类，扫描注解
        doScan(properties.getProperty("scanPackage"));
        //3、初始化bean对象（实现IOC容器，基于注解）
        try {
            doInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

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
    private void doInstance() throws IllegalAccessException, InstantiationException {
        if (classNameCaches.size() == 0) {
            return;
        }
        try {
            for (int i = 0; i < classNameCaches.size(); i++) {
                String className = classNameCaches.get(i);
                //反射
                Class<?> aClass = Class.forName(className);

                //区分controller、service
                if (aClass.isAnnotationPresent(TestController.class)) {
                    // controller的id此处不做过多处理，不取value了，就拿类的首字母小写作为id，保存到ioc中
                    // DemoController
                    String simpleName = aClass.getSimpleName();
                    // demoController
                    String lowerFirstSimpleName = lowerFirst(simpleName);
                    Object o = aClass.newInstance();
                    ioc.put(lowerFirstSimpleName, o);
                } else if (aClass.isAnnotationPresent(TestService.class)) {
                    TestService annotation = aClass.getAnnotation(TestService.class);
                    //获取注解的value的值
                    String beanName = annotation.value();
                    // 如果指定了id，就以指定的为准
                    if (!"".equals(beanName.trim())) {
                        ioc.put(beanName, aClass.newInstance());
                    } else {
                        // 如果没有指定，就以类名首字母小写
                        beanName = lowerFirst(aClass.getSimpleName());
                        ioc.put(beanName, aClass.newInstance());
                    }
                    // service层往往是有接口的，面向接口开发，此时再以接口名为id，放入一份对象到ioc中，便于后期根据接口类型注入
                    Class<?>[] interfaces = aClass.getInterfaces();
                    for (int j = 0; j < interfaces.length; j++) {
                        Class<?> anInterface = interfaces[j];
                        // 以接口的全限定类名作为id放入
                        ioc.put(anInterface.getName(), aClass.newInstance());
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 首字母小写方法
     *
     * @param str
     * @return
     */
    public String lowerFirst(String str) {
        char[] chars = str.toCharArray();
        if ('A' <= chars[0] && chars[0] <= 'Z') {
            chars[0] += 32;
        }
        return String.valueOf(chars);
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
