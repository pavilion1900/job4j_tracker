package ru.job4j.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        boolean rsl = true;
        int sum = 0;
        for (int i = 1; i < data.size() - 1; i++) {
            if (data.get(i) != (data.get(i - 1) + data.get(i + 1)) / 2
                    && (data.get(i - 1) + data.get(i + 1)) % 2 != 0) {
                rsl = false;
                break;
            }
        }
        if (rsl) {
            for (int number : data) {
                sum += number;
            }
        }
        return sum;
    }
}
