package ru.job4j.comparator;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {
    public static Map<Integer, String> sort(Map<Integer, String> map) {
        Map<Integer, String> stringMap = new TreeMap<>(Comparator.reverseOrder());
        stringMap.putAll(map);
        return stringMap;
    }
}
