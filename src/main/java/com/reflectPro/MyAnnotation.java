package com.reflectPro;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})// 指定注解可以使用的位置
@Retention(RetentionPolicy.RUNTIME)// 保留到运行阶段
public @interface MyAnnotation {
    int age() default 0;
}
