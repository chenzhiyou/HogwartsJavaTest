package learn.ch26_stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapDemo {
    public static void main(String[] args) {
        Stream<String> hogwarts = Stream.of("Hogwarts", "霍格沃兹");
        List<String> list = hogwarts.map(x -> x + "666")
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
