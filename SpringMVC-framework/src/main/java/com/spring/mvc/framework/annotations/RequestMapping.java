package com.spring.mvc.framework.annotations;

import java.lang.annotation.*;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value() default "";
}
