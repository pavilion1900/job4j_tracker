package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String answer = "Вы сделали правильный выбор!";
        Set<String> article = new HashSet<>(Set.of(s.split(" ")));
        for (String s1 : article) {
            if (words.contains(s1)) {
                answer = "Выберите другую статью...";
                break;
            }
        }
        return answer;
    }
}