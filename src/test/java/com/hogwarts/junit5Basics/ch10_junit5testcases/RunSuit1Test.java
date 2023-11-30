package com.hogwarts.junit5Basics.ch10_junit5testcases;


import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses({OrderExampleTest.class, NestedExampleTest.class})
@SelectPackages("com.hogwarts.junit5Basics.ch08_junit5casename")
public class RunSuit1Test {

}
