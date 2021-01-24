package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int total = 0;
        int[] number = {1, 2, 3};
        for (int i = 0; i < number.length; i++) {
            int temp = total;
            int num = number[i];
            total = add(() -> temp + num);
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
