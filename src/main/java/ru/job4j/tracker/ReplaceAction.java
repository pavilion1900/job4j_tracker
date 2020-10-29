package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id ");
        String newName = input.askStr("Enter a new name ");
        Item item = new Item();
        item.setName(newName);
        if (tracker.replace(id, item)) {
            System.out.println("Editing completed successfully");
        } else {
            System.out.println("Attention, editing did not happen");
        }
        return true;
    }
}
