package ru.job4j.list;

import java.util.Arrays;

public class Alphabet {
    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
