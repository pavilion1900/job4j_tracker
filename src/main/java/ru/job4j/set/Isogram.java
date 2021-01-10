package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<Character> set = new HashSet<>();
        for (Character elem : s.toCharArray()) {
            set.add(elem);
        }
        return set.size() == s.length();
    }
}
