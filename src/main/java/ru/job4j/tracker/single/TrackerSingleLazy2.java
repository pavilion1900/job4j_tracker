package ru.job4j.tracker.single;

import ru.job4j.tracker.Item;

public class TrackerSingleLazy2 {
    private TrackerSingleLazy2() {

    }

    public static TrackerSingleLazy2 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleLazy2 INSTANCE = new TrackerSingleLazy2();
    }

    public static void main(String[] args) {
        TrackerSingleLazy2 tracker = TrackerSingleLazy2.getInstance();
    }
}
