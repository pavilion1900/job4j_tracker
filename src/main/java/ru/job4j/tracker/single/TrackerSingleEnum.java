package ru.job4j.tracker.single;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum TrackerSingleEnum {
    INSTANCE;
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker = INSTANCE.getInstance();
    }
}
