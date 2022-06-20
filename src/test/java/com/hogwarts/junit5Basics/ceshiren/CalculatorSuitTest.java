package com.hogwarts.junit5Basics.ceshiren;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        com.hogwarts.junit5Basics.ceshiren.CalculatorSumTest.class,
        com.hogwarts.junit5Basics.ceshiren.CalculatorSubtractTest.class,
        com.hogwarts.junit5Basics.ceshiren.CalculatorConcatStrTest.class
})
public class CalculatorSuitTest {
}
