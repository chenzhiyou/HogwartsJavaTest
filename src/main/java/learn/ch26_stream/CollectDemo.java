package learn.ch26_stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
        Stream<String> hogwartsStream = Stream.of("Hogwarts", "霍格沃兹");

        Set<String> mySet = hogwartsStream.filter(s -> s.startsWith("H"))
                .collect(Collectors.toSet());
        System.out.println(mySet);
    }
}
