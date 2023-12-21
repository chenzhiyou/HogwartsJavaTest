package com.hogwarts.learn.ch07_displayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

// 显示的名称为默认的格式
//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
// Simple 显示的名称如果是没有参数的方法则去掉括号，如果有参数则维持原样
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
// ReplaceUnderscores 替换掉带_部分为空格
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//IndicativeSentences 将显示名称换为类名, 方法名
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DisplayNameExampleTest {


    @Test
    @DisplayName("第一条用例")
    void hogwartsOne(){
        System.out.println("第一条用例");
    }

    @Test
    @DisplayName("第二条用例")
    void hogwartsTwo(){
        System.out.println("第二条用例");
    }
}
