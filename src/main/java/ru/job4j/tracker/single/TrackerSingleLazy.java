package ru.job4j.tracker.single;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingleLazy {
    private static Tracker instance;

    private TrackerSingleLazy() {

    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleLazy.getInstance();
    }
}
