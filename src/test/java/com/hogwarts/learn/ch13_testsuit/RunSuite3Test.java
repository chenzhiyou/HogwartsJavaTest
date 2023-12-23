package com.hogwarts.learn.ch13_testsuit;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.hogwarts.learn")
@IncludePackages("ch09_order")
@ExcludePackages("ch01_rules")
public class RunSuite3Test {
}
