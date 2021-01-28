package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Optional;

public class OptionalIfPresent {
    public static void ifPresent(int[] data) {
        if (max(data).isPresent()) {
            Optional.of(max(data).get()).ifPresent(num -> System.out.println("Max: " + num));
        } else {
            Optional.empty().ifPresent(System.out::println);
        }
    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> rsl = Optional.empty();
        if (data.length > 0) {
            Arrays.sort(data);
            int max = data[data.length - 1];
            rsl = Optional.of(max);
        }
        return rsl;
    }
}

