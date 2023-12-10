package learn.ch26_stream;

import java.util.stream.Stream;

public class CountDemo {
    public static void main(String[] args) {
        Stream<String> hogwartsStream = Stream.of("Hogwarts", "霍格沃兹");
        long count = hogwartsStream.count();
        System.out.println(count);
    }
}
