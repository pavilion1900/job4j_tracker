package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ===");
                Item[] allItems = tracker.findAll();
                for (int i = 0; i < allItems.length; i++) {
                    System.out.println(allItems[i]);
                }
            } else if (select == 2) {
                System.out.println("=== Editing starts ===");
                int id = input.askInt("Enter id ");
                String name = input.askStr("Enter a new name ");
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Editing completed successfully");
                } else {
                    System.out.println("Attention, editing did not happen");
                }
            } else if (select == 3) {
                System.out.println("=== Deleting starts ===");
                int id = input.askInt("Enter id ");
                if (tracker.delete(id)) {
                    System.out.println("Deleting completed successfully");
                } else {
                    System.out.println("Attention, deleting did not happen");
                }
            } else if (select == 4) {
                System.out.println("=== Finding item by Id ===");
                int id = input.askInt("Enter id ");
                Item findItem = tracker.findById(id);
                if (findItem != null) {
                    System.out.println("id: " + findItem.getId() + ", name: " + findItem.getName()
                            + ", created: " + findItem.getCreated());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Finding item by name ===");
                String name = input.askStr("Enter name ");
                Item[] findItems = tracker.findByName(name);
                if (findItems.length > 0) {
                    for (int i = 0; i < findItems.length; i++) {
                        System.out.println(findItems[i]);
                    }
                } else {
                    System.out.println("Заявка с таким name не найдена");
                }
            } else if (select == 6) {
                System.out.println("=== Good bye ===");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item \n"
                + "1. Show all items \n"
                + "2. Edit item \n"
                + "3. Delete item \n"
                + "4. Find item by Id \n"
                + "5. Find items by name \n"
                + "6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}