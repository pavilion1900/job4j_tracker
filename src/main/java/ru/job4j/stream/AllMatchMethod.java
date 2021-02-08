package ru.job4j.stream;

import java.util.List;

public class AllMatchMethod {
    public static boolean check(List<String> list) {
        return list.stream().allMatch(elem -> elem.length() > 3);
    }
}
