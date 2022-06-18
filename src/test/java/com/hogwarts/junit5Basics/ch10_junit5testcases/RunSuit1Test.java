package com.hogwarts.junit5Basics.ch10_junit5testcases;

import com.hogwarts.junit5Basics.ch08_junit5casename.NestedExampleTest;
import com.hogwarts.junit5Basics.ch08_junit5casename.OrderExampleTest;
import com.hogwarts.junit5Basics.ch09_junit5tag.DisableExampleTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses({OrderExampleTest.class, NestedExampleTest.class})
@SelectPackages("com.hogwarts.junit5Basics.ch08_junit5casename")
public class RunSuit1Test {

}
