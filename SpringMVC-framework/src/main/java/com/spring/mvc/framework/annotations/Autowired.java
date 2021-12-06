package com.spring.mvc.framework.annotations;

import java.lang.annotation.*;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

    String value() default "";
}
