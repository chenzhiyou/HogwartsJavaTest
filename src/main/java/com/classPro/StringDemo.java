package com.classPro;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        String str = "hello, world";
        // 使用构造函数进行构建
        String strHello = new String("hello");

        // 字符数组构建字符串
        char[] charArr = {'c', '2', 'y'};
        String charStr = new String(charArr);
        System.out.println("charStr: "+ charStr);

        // 字节数组构建字符串
        byte[] byteArr = {97,98,99,100};
        String byteStr = new String(byteArr);
        System.out.println("byteStr: "+ byteStr);

        String string = "abcd123456";

        // charAt
        char ch = string.charAt(2);
        System.out.println(ch);

        // concat 字符串拼接
        // contains 包含
        boolean containsBool = string.contains("ab");
        System.out.println(containsBool);

        // endWith 以。。。结尾
        String textStr = "hello.text";
        boolean text = textStr.endsWith("text");
        System.out.println(text);

        //搜索： indexOf() 返回指定字符第一次出现在字符串内的索引，以指定的索引开始搜索
        // lastIndexOf() 返回指定子字符串的最后一次属性的字符串中的索引，从指定索引开始向后搜索
        String str3 = "helloworld!!";
        int index = str3.indexOf("e");
        System.out.println("index: " + index);

        // replace 字符串的替换
        String str5 = "abcwwwdef";
        String www = str5.replace("www", "123");
        System.out.println("字符串的替换："+ www);

        // split 按照切符，将此字符串分隔为数组，注意点：分隔符放在首尾，中间起作用，放在末尾不起作用
        String str6 = "==www====woow==123==";
        String[] split = str6.split("==");
        System.out.println("分割得到的数组： "+ Arrays.toString(split));

        // substring 截取，返回一个字符串，该字符串是此字符串的子字符串
        String str7 = "aaabbb";
        String substring = str7.substring(2);
        System.out.println("substring: " + substring);
        String substring1 = str7.substring(0, 3); // 包含前面的索引，不包含后面的索引
        System.out.println("substring1: " + substring1);

        // toLowerCase() 转小写
        // toUpperCase() 转大写
        // trim() 去掉空格
        String str8 = "he llo";
        String trim = str8.trim();
        System.out.println("去除空格的字符串: "+ trim);

        /**
         * 内存分析
         */
        String str9 = "abcd";
        String str10 = new String("abcd");
        System.out.println("str9==str10: "+ (str9==str10)); // 内存地址一样吗？

        String str11= "ab";
        String str12 = "cd";
        String newStr = str11+str12; //new StringBuilder().append(str11).append(str12).toString()
        System.out.println("str9==newStr: "+(str9==newStr));

        String newStr2 = "ab"+"cd"; // 拼接之后就是"abcd", 就是字符串里面的地址，而字符串常量池里面就只有一份数据
        System.out.println("str9==newStr2: "+(str9==newStr2));
        final String str13 = "cd";
        String newStr3 = "ab"+str13;
        System.out.println("str9==newStr3: "+(str9==newStr3));

        // 在常量池中产生了两个字符串，用String生成的字符串是不可变的
        String str14 = "123";
        str14 += "abc";
        System.out.println("str14: "+ str14);

        // 可变字符串 StringBuffer 线程安全，运行效率慢
        // StringBuilder 线程不安全，运行效率快

        long starTime = System.currentTimeMillis();
        String str15 = "";
        for (int i =0; i < 99999; i++){
            str15 += i;
        }
        long endTime = System.currentTimeMillis();
        long useTime = endTime - starTime;
        System.out.println("String方法的持续时间：" + useTime);

        starTime = System.currentTimeMillis();
        StringBuffer str16 = new StringBuffer();
        for (int i =0; i < 99999; i++){
            str16.append(i);
        }
        endTime = System.currentTimeMillis();
        useTime = endTime - starTime;
        System.out.println("StringBuffer方法的持续时间：" + useTime);


        starTime = System.currentTimeMillis();
        StringBuilder str17 = new StringBuilder();
        for (int i =0; i < 99999; i++){
            str17.append(i);
        }
        endTime = System.currentTimeMillis();
        useTime = endTime - starTime;
        System.out.println("StringBuilder方法的持续时间：" + useTime);

    }
}
