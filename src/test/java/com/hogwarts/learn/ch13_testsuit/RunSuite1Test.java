package com.hogwarts.learn.ch13_testsuit;

import com.hogwarts.learn.ch09_order.OrderClassExampleTest;
import com.hogwarts.learn.ch09_order.OrderExampleTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses(OrderExampleTest.class)
@SelectClasses({
        OrderExampleTest.class,
        OrderClassExampleTest.class
})
public class RunSuite1Test {
}
