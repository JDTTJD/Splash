package com.tuoren.splash;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Create by JDT on 2019/11/6.
 */
//注解的保留期
@Retention(RUNTIME) //运行时注解
@Target(TYPE)       //类接口注解
public @interface ViewInject {
    int mainlayoutid() default -1;
}
