package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String values) {
        Optional<String> rsl = Optional.empty();
        if (strings.contains(values)) {
            rsl = Optional.ofNullable(values);
        }
        return rsl;
    }
}
