package ru.job4j.tracker.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> list = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new SortByNameJob());
        System.out.println(list);
    }
}
