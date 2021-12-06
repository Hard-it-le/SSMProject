package com.spring.mvc.framework.servlet;


import com.spring.mvc.framework.annotations.Autowired;
import com.spring.mvc.framework.annotations.RequestMapping;
import com.spring.mvc.framework.annotations.TestController;
import com.spring.mvc.framework.annotations.TestService;
import com.spring.mvc.framework.pojo.Handler;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    /**
     * handlerMapping
     * 存储url和Method之间的映射关系
     */
    //  private Map<String, Method> handlerMapping = new HashMap<>();
    private List<Handler> handlerMapping = new ArrayList<>();

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
     * 最关键的环节
     * 目的：将url和method建立关联
     */
    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            //获取ioc中当前遍历的对象的class类型
            Class<?> aClass = entry.getValue().getClass();

            if (!aClass.isAnnotationPresent(TestController.class)) {
                continue;
            }

            String baseUrl = "";
            if (aClass.isAnnotationPresent(TestController.class)) {
                RequestMapping annotation = aClass.getAnnotation(RequestMapping.class);
                // 等同于/demo
                baseUrl = annotation.value();
            }

            //获取方法
            Method[] methods = aClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                //  方法没有标识RequestMapping，就不处理
                if (!aClass.isAnnotationPresent(RequestMapping.class)) {
                    continue;
                }
                // 如果标识，就处理
                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                //相当于query
                String methodUrl = annotation.value();
                // 计算出来的url /demo/query
                String url = baseUrl + methodUrl;
                // 把method所有信息及url封装为一个Handler
                Handler handler = new Handler(entry.getValue(), method, Pattern.compile(url));
                // 计算方法的参数位置信息  // query(HttpServletRequest request, HttpServletResponse response,String name)
                Parameter[] parameters = method.getParameters();
                for (int j = 0; j < parameters.length; j++) {
                    Parameter parameter = parameters[j];
                    if (parameter.getType() == HttpServletRequest.class || parameter.getType() == HttpServletResponse.class) {
                        // 如果是request和response对象，那么参数名称写HttpServletRequest和HttpServletResponse
                        handler.getParamIndexMapping().put(parameter.getType().getSimpleName(), j);
                    } else {
                        // <name,2>
                        handler.getParamIndexMapping().put(parameter.getName(), j);
                    }
                }
                // 建立url和method之间的映射关系（map缓存起来）
                handlerMapping.add(handler);
            }
        }
    }

    /**
     * 实现依赖注入
     */
    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }

        //1、如果有对象，再进行依赖注入

        //2、遍历ioc中所有对象，查看对象中的字段，是否有@LagouAutowired注解，如果有需要维护依赖注入关系
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            //获取bean对象的字段信息

            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {

                Field declaredField = declaredFields[i];
                if (!declaredField.isAnnotationPresent(Autowired.class)) {
                    continue;
                }

                Autowired annotation = declaredField.getAnnotation(Autowired.class);
                // 需要注入的bean的id
                String beanName = annotation.value();
                if ("".equals(beanName.trim())) {
                    // 没有配置具体的bean id，那就需要根据当前字段类型注入（接口注入）  IDemoService
                    beanName = declaredField.getType().getName();
                }
                // 开启赋值
                declaredField.setAccessible(true);
                try {
                    declaredField.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

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
        // 处理请求：根据url，找到对应的Method方法，进行调用
        // 获取uri
        // String requestURI = req.getRequestURI();
        // 获取到一个反射的方法
        //Method method = handlerMapping.get(requestURI);
        // 反射调用，需要传入对象，需要传入参数，此处无法完成调用，没有把对象缓存起来，也没有参数！！！！改造initHandlerMapping();
        //  method.invoke();

        //根据url获取到当前处理请求的handler中
        Handler handler = getHandler(req);

        if (null == handler) {
            resp.getWriter().write("404 not found");
            return;
        }

        //参数绑定
        // 获取所有参数类型数组，这个数组的长度就是我们最后要传入的args数组的长度
        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        //根据上述数组长度创建一个新的数组，反射用
        Object[] paramValues = new Object[parameterTypes.length];

        // 以下就是为了向参数数组中塞值，而且还得保证参数的顺序和方法中形参顺序一致
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 遍历request中所有参数  （填充除了request，response之外的参数）
        for (Map.Entry<String, String[]> param : parameterMap.entrySet()) {
            // name=1&name=2   name [1,2]
            // 如同 1,2
            String value = StringUtils.join(param.getValue(), ",");
            // 如果参数和方法中的参数匹配上了，填充数据
            if (!handler.getParamIndexMapping().containsKey(param.getKey())) {
                continue;
            }
            // 方法形参确实有该参数，找到它的索引位置，对应的把参数值放入paraValues
            //name在第 2 个位置
            Integer index = handler.getParamIndexMapping().get(param.getKey());
            // 把前台传递过来的参数值填充到对应的位置去
            paramValues[index] = value;
        }

        Integer requestIndex = handler.getParamIndexMapping().get(HttpServletRequest.class.getSimpleName());
        paramValues[requestIndex] = req;

        Integer responseIndex = handler.getParamIndexMapping().get(HttpServletResponse.class.getSimpleName());
        paramValues[responseIndex] = resp;


        // 最终调用handler的method属性
        try {
            handler.getMethod().invoke(handler.getController(), paramValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Handler getHandler(HttpServletRequest req) {

        if (handlerMapping.isEmpty()) {
            return null;
        }

        String url = req.getRequestURI();
        for (Handler handler : handlerMapping) {

            Matcher matcher = handler.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handler;
        }
        return null;
    }
}
