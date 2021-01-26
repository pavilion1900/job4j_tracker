package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> rsl = Optional.empty();
        for (String s : strings) {
            if (s.contains(value)) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }
}
