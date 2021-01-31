package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = List.of(-20, 50, 36, -54, 1, 9, 18);
        list = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}