package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMap {
    public static List<Integer> matrixToList(Integer[][] array) {
        return Stream.of(array)
                .flatMap(arr -> Arrays.stream(arr))
                .collect(Collectors.toList());
    }
}
