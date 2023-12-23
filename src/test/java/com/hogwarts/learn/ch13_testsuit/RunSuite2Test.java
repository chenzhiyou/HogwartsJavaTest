package com.hogwarts.learn.ch13_testsuit;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages("com.hogwarts.learn.ch09_order")
@SuiteDisplayName("执行多个测试包的Suite套件")
public class RunSuite2Test {
}
