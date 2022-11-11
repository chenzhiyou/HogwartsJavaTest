package com.ajaxPro;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;

import java.util.List;

public class FastjsonDemo {
    public static void main(String[] args) {
        // 简单JSON对象格式解析
        String str = "{\"name\":\"wowo\", \"age\":23, \"sex\":\"男\", status: true}";
        Person person = JSONObject.parseObject(str, Person.class);
        System.out.println(person.getName()+ ":"+ person.getAge());
        // 复杂的JSON格式解析成对象
        String json = "{\"name\":\"wowo\", \"age\":23, \"sex\":\"男\",score:{\"englishScore\":88, \"mathScore\":66}}";
        Person person1 = JSONObject.parseObject(json, Person.class);
        System.out.println(person1.getScore());

        String jsonArr = "[{\"englishScore\":88, \"mathScore\":66}, {\"englishScore\":45, \"mathScore\":98}]";
        List<Score> scores = JSON.parseArray(jsonArr, Score.class);
        for (Score score:scores){
            System.out.println(score);
        }


    }
}
