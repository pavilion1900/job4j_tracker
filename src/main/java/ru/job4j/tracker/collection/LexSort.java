package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        String[] leftArray = left.split(". ");
        String[] rightArray = right.split(". ");
        int first = Integer.parseInt(leftArray[0]);
        int second = Integer.parseInt(rightArray[0]);
        return Integer.compare(first, second);
    }
}
