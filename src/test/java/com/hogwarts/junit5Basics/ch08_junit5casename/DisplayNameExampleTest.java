package com.hogwarts.junit5Basics.ch08_junit5casename;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * DisplayName适合修饰类和方法
 * @DisplayNameGeneration(DisplayNameGenerator.Standard.class)  显示的名称为默认样式
 * @DisplayNameGeneration(DisplayNameGenerator.Simple.class) 显示的名称如果是没有参数的方法，就去掉括号，如果有参数则维持原样
 * @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) 去掉方法名中的下划线
 * @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class) 将显示名称换成类名,方法名
 */

//@DisplayName("霍格沃兹演示类")
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DisplayNameExampleTest {

    @Test
    @DisplayName("霍格沃兹第一条用例")
    void hogwartsOne(){
        System.out.println("第一条测试用例");
    }

    @Test
    void hogwartsTwo(){
        System.out.println("第二条测试用例");
    }

    @Test
    void hogwarts_three(){
        System.out.println("第三条测试用例");
    }
}
