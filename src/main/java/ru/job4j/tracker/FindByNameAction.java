package ru.job4j.tracker;

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
        Item[] findItems = tracker.findByName(name);
        if (findItems.length > 0) {
            for (int i = 0; i < findItems.length; i++) {
                out.println(findItems[i]);
            }
        } else {
            out.println("Заявка с таким name не найдена");
        }
        return true;
    }
}
