package com.spring.mvc.framework.annotations;

import java.lang.annotation.*;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 *
 * service注解
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestService {

    String value() default "";
}
