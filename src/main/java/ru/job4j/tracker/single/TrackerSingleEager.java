package ru.job4j.tracker.single;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingleEager {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleEager() {

    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleEager.getInstance();
    }
}
