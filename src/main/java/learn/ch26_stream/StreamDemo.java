package learn.ch26_stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Collection获取流
        Stream<Integer> listStream = new ArrayList<Integer>().stream();
        Stream<Integer> setStream = new HashSet<Integer>().stream();
        Stream<Integer> vectorStream = new Vector<Integer>().stream();

        // Map接口获取流
        HashMap<String, String> map = new HashMap<>();
        Stream<String> keys = map.keySet().stream();
        Stream<String> values = map.values().stream();
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();

    }
}
