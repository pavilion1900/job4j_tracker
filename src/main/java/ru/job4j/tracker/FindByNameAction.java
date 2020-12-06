package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name ");
        List<Item> findItems = tracker.findByName(name);
        if (findItems.size() > 0) {
            for (Item item : findItems) {
                out.println(item);
            }
        } else {
            out.println("Заявка с таким name не найдена");
        }
        return true;
    }
}
