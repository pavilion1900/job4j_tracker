package ru.job4j.set;

import java.util.Set;
import java.util.TreeSet;

public class Pangram {
    public static boolean checkString(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        Set<Character> characters = new TreeSet<>();
        for (char ch : chars) {
            if (ch != ' ') {
                characters.add(ch);
            }
        }
        Set<Character> setAlphabet = new TreeSet<>();
        for (char i = 'a'; i <= 'z'; i++) {
            setAlphabet.add(i);
        }
        return characters.size() == setAlphabet.size() && characters.containsAll(setAlphabet);
    }
}
