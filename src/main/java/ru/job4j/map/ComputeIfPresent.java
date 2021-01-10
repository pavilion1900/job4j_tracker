package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        Map<Integer, String> rsl = new HashMap<>(name);
        for (Integer elem : rsl.keySet()) {
            rsl.computeIfPresent(elem, (key, value) -> value + " " + surname.get(elem));
        }
        return rsl;
    }
}
