package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
    private final Output out;

    public ShowAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (int i = 0; i < allItems.length; i++) {
            out.println(allItems[i]);
        }
        return true;
    }
}
