package learn.ch26_stream;

import java.util.stream.Stream;

public class ForEachDemo {
    public static void main(String[] args) {
        Stream<String> hogwartsStream = Stream.of("Hogwarts", "霍格沃兹");
        hogwartsStream.forEach(x-> System.out.println(x));
    }
}
