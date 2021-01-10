package ru.job4j.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        Set<String> set = new HashSet<>();
        for (String s : combination) {
            set.add(s);
        }
        return set.size() == 1;
    }
}
