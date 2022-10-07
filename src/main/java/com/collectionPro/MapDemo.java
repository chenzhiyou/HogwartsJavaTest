package com.collectionPro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // 添加元素： key要唯一
        map.put("aaa", "1000");
        map.put("bbb", "2000");
        map.put("ccc", "3000");
        System.out.println("map: " + map);
        // 获取元素
        System.out.println("获取元素： "+ map.get("aaa"));
        boolean result = map.containsKey("aaa");

        // 删除元素
        map.remove("aaa");
        System.out.println("删除之后的map: " + map);

        // 遍历
        Set<String> keySet = map.keySet();
        for (String key: keySet){
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
        // 遍历2：
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry:entries){
            System.out.println(entry);
        }

        // HashMap
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("aaa", 1);
        newMap.put("ddd", 1);
        newMap.put("ccc", 1);
        newMap.put("qqq", 1);
        System.out.println("newMap: "+ newMap);
    }
}
