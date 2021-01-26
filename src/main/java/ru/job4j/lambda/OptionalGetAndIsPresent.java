package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {
    public static int get(int[] data, int el) {
        int rsl = -1;
        Optional<Integer> temp = indexOf(data, el);
        if (temp.isPresent()) {
            rsl = temp.get();
        }
        return rsl;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> rsl = Optional.empty();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rsl = Optional.of(i);
                break;
            }
        }
        return rsl;
    }
}
