package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("Enter id");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter a new name");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Editing completed successfully");
                } else {
                    System.out.println("Attention, editing did not happen");
                }
            } else if (select == 3) {
                System.out.println("=== Deleting starts ===");
                System.out.println("Enter id");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Deleting completed successfully");
                } else {
                    System.out.println("Attention, deleting did not happen");
                }
            } else if (select == 4) {
                System.out.println("=== Finding item by Id ===");
                System.out.println("Enter id");
                int id = Integer.valueOf(scanner.nextLine());
                Item findItem = tracker.findById(id);
                if (findItem != null) {
                    System.out.println("id: " + findItem.getId() + ", name: " + findItem.getName()
                            + ", created: " + findItem.getCreated());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Finding item by name ===");
                System.out.println("Enter name");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}