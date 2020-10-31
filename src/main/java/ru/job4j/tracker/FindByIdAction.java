package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id ");
        Item findItem = tracker.findById(id);
        if (findItem != null) {
            out.println("id: " + findItem.getId() + ", name: " + findItem.getName()
                    + ", created: " + findItem.getCreated());
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
