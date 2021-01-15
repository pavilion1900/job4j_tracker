package ru.job4j.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> setOrigin = new LinkedHashSet<>();
        Set<String> setLine = new LinkedHashSet<>();
        for (String s : origin.split("[^A-Za-zА-Яа-я]+")) {
            setOrigin.add(s);
        }
        for (String s : line.split("[^A-Za-zА-Яа-я]+")) {
            setLine.add(s);
        }
        return setOrigin.containsAll(setLine);
    }
}