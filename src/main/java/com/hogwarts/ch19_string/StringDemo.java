package com.hogwarts.ch19_string;

import java.util.Locale;

/**
 * 字符串是一个字符(char)序列
 *      char只是表示字符
 * String类型不是基本数据类型，而是引用类型
 *      引用类型声明的变量称 引用变量
 * 字符串的拼接：Java语言允许使用+号拼接两个字符串
 *      注意：当将一个字符串与一个非字符串的值进行拼接时，后者被转换成字符串
 * toLowerCase 全部转换为小写， toUpperCase 全部转换为大写
 * trim 删除前面和后面的空白字符，中间的空白字符不做处理,不管前后有多少个空格，都会进行处理掉
 * equals 判断字符串是否相同，区分大小写
 * equalsIgnoreCase 判断字符串是否相同，不区分大小写
 * 判断string对应的内容是否相同，不要使用==，==是判断对象地址的，是否指向同一个对象，不会比较字符串的内容是否相等
 * 是否包含：contains(s1)，返回true或者false，判断S1是否为字符串的子字符串
 * startsWith、endsWith 字符串以某些开始或结尾
 * replace(old, new)字符串的替换
 * valueOf()将字符和数值转换为String类型
 */
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Hogwarts";
        char data[] = {'H','o', 'g', 'w', 'a', 'r', 't', 's'};
        String str2 = new String(data);

        System.out.println(str1);
        System.out.println(str2);

        System.out.println("------------字符串拼接----------------");
        String str3 = "Hello,";
        System.out.println(str3 +str1);

        int age = 5;
        System.out.println(str1 + "的年龄是"+ age);
        // str1.length()的返回值为int类型
        System.out.println("字符串的长度是"+ str1.length());
        // toLowerCase 全部转换为小写， toUpperCase 全部转换为大写
        System.out.println(str1.toLowerCase(Locale.ROOT));
        System.out.println(str1.toUpperCase(Locale.ROOT));

        // trim 删除前面和后面的空白字符，中间的空白字符不做处理
        String str4 = "   this is string          ";
        System.out.println(str4.trim());
        System.out.println(str4.length());
        System.out.println(str4.trim().length());

        System.out.println("----------------判断相等---------------");
        System.out.println("判断字符串是否相等："+ str1.equals(str2));
        System.out.println("判断字符串是否相等："+ str1.equalsIgnoreCase(str2));

        System.out.println("字符串是否以某些开始或结尾");
        System.out.println(str1.startsWith("H"));
        System.out.println(str1.endsWith("s"));
        // 字符串截取
        System.out.println("------------字符串截取-------------");
        String str5 = str1.substring(1);
        String str6 = str1.substring(2, 4);
        System.out.println(str5);
        System.out.println(str6);

        String name = "张 小强";
        int indexOf = name.indexOf(" ");
        String firstName = name.substring(0, indexOf);
        String lastName = name.substring(indexOf+1);
        System.out.println("姓:" + firstName);
        System.out.println("名:"+ lastName);

        System.out.println("----------转换为String类型");
        int va = 200;
        String i = String.valueOf(va);


    }
}
