package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }

    private static List<Double> linearFunction(int start, int end) {
        return diapason(start, end, num -> 2 * num + 1);
    }

    private static List<Double> squareFunction(int start, int end) {
        return diapason(start, end, num -> Math.pow(num, 2));
    }

    private static List<Double> showFunction(int start, int end) {
        return diapason(start, end, num -> Math.pow(num, num));
    }
}
