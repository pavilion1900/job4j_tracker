package ru.job4j.tracker.collection;

import java.util.Comparator;

public class JobIncreaseByName implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
