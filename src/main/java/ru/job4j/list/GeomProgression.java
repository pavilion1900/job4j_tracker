package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        list.add(first);
        for (int i = 1; i < count; i++) {
            list.add(list.get(i - 1) * denominator);
        }
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
