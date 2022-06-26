package com.hogwarts.junit5Basics.self;


import org.junit.platform.suite.api.Suite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Suite
public @interface SelfSuite {
}
