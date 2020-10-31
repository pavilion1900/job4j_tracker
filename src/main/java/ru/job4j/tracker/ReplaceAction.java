package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

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
            out.println("Editing completed successfully");
        } else {
            out.println("Attention, editing did not happen");
        }
        return true;
    }
}
