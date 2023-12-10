package learn.ch24_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        System.out.println("m1: "+ m1);
        m1.put("1", "hello");
        m1.put("2", "map");
        m1.put("three", "HashMap");
        m1.put("2", "Good");
        System.out.println("m1: "+ m1);
        System.out.println("three对应的Value为： "+ m1.get("three"));
        System.out.println("m1是否包含Key：three： "+ m1.containsKey("three"));
        System.out.println("是否包含Good："+ m1.containsValue("Good"));
        System.out.println("是否包含map："+m1.containsValue("map"));
        System.out.println("m1中所有的Key： "+ m1.keySet());
        Collection<String> values = m1.values();
        for (String value : values){
            System.out.println("value: "+ value);
        }
        Set<Map.Entry<String, String>> entries = m1.entrySet();
        for (Map.Entry<String, String> map :entries){
            System.out.println("键值对方式进行输出： "+ map);
        }
        System.out.println("删除元素： "+ m1.remove("1"));
        System.out.println("m1: "+ m1);


    }
}
