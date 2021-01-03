package ru.job4j.tracker.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> list = Arrays.asList(
                new Job("Fix bugs", 1),
                new Job("Fix bugs", 4),
                new Job("Fix bugs", 2),
                new Job("X task", 0));
        System.out.println(list);
        Collections.sort(list, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(list);
        Collections.sort(list, new JobDescByName()
                .thenComparing(new JobDescByPriority())
                .thenComparing(new JobDescByNameLn()));
        System.out.println(list);
    }
}
