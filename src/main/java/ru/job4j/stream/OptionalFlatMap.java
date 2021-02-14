package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class OptionalFlatMap {
    public static Optional<Integer> flatMap(List<String> strings) {
        return strings.stream()
                .filter(elem -> elem.endsWith(".java"))
                .findFirst().stream()
                .map(elem -> elem.length())
                .findFirst();
    }
}
