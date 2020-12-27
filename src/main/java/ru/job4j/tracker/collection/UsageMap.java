package ru.job4j.tracker.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pavilion1900@gmail.com", "Sergey Korolenko");
        map.put("pavilion1900@mail.ru", "Ivan Ivanov");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}