package ru.job4j.tracker.collection;

import java.util.Comparator;

public class JobDescByNameLn implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(second.getName().length(), first.getName().length());
    }
}
