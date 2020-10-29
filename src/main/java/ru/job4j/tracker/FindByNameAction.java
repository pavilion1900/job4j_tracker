package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
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
                System.out.println(findItems[i]);
            }
        } else {
            System.out.println("Заявка с таким name не найдена");
        }
        return true;
    }
}
