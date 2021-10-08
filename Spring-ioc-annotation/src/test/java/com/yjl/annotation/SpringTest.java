package com.yjl.annotation;

import com.yjl.annotation.configuration.MyConfiguration;
import com.yjl.annotation.controller.SoldierController;
import com.yjl.annotation.mapper.SoldierMapper;
import com.yjl.annotation.service.SoldierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yujiale
 * @Classname SpringTest
 * @Description TOO
 * @Date 2021/9/25 下午9:10
 * @Created by yujiale
 */
public class SpringTest {

    // ClassPathXmlApplicationContext 根据 XM L配置文件创建 IOC 容器对象
    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");

    // AnnotationConfigApplicationContext 根据配置类创建 IOC 容器对象
    private ApplicationContext iocContainerAnnotation = new AnnotationConfigApplicationContext(MyConfiguration.class);

    @Test
    public void annotation01Test() {

        SoldierController controller = iocContainer.getBean(SoldierController.class);

        controller.test();
    }

    @Test
    public void annotationTest() {
        CommonComponent component = iocContainer.getBean(CommonComponent.class);
        SoldierController controller = iocContainer.getBean(SoldierController.class);
        SoldierService service = iocContainer.getBean(SoldierService.class);
        SoldierMapper mapper = iocContainer.getBean(SoldierMapper.class);
        System.out.println(component);
        System.out.println(controller);
        System.out.println(service);
        System.out.println(mapper);
    }
}
