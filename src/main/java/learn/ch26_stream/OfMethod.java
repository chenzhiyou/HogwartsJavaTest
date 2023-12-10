package learn.ch26_stream;

import java.util.stream.Stream;

public class OfMethod {
    public static void main(String[] args) {
        Stream<Integer> numStream = Stream.of(1, 2, 3);

        String[] words = {"java", "Python", "go"};
        Stream<String> stringStream = Stream.of(words);
    }
}
