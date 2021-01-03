package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int rsl = 0;
        for (int i = 0; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                rsl = Character.compare(first.charAt(i), second.charAt(i));
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(first.length(), second.length());
        }
        return rsl;
    }
}
