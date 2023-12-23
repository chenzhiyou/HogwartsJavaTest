package com.hogwarts.learn.ch13_testsuit;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.hogwarts.learn.ch09_order")
@IncludeClassNamePatterns("com.hogwarts.learn.ch09_order.*Test")
public class RunSuite4Test {
}
