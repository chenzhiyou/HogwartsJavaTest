package com.ajaxPro;

import com.alibaba.fastjson.JSON;

public class FastDemo2 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("xiaozhang");
        p.setAge(23);
        p.setSex("女");

        //转成JSON格式的字符串
        System.out.println(JSON.toJSONString(p));
    }
}
