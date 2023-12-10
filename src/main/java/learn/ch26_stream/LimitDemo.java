package learn.ch26_stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitDemo {
    public static void main(String[] args) {
        Stream<String> hogwartsStream = Stream.of("Hogwarts", "霍格沃兹");
        List<String> collect = hogwartsStream.limit(1)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
