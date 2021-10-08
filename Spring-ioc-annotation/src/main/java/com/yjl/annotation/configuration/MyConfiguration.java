package com.yjl.annotation.configuration;

import com.yjl.annotation.CommonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yujiale
 * @Classname MyConfiguration
 * @Description TOO
 * @Date 2021/9/25 下午9:43
 * @Created by yujiale
 */
@Configuration
@ComponentScan("com.yjl.annotation")
public class MyConfiguration {
    // @Bean 注解相当于 XML 配置文件中的 bean 标签
    // @Bean 注解标记的方法的返回值会被放入 IOC 容器
    // 默认以方法名作为 bean 的 id
    @Bean
    public CommonComponent getComponent() {
        CommonComponent commonComponent = new CommonComponent();
        commonComponent.setComponentName("created by annotation config");
        return commonComponent;
    }
}
