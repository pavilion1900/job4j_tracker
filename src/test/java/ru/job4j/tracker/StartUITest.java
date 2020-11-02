package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] actions = {new CreateAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), replacedName, "1"});
        Output output = new StubOutput();
        UserAction[] actions = {new ReplaceAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        Output output = new StubOutput();
        UserAction[] actions = {new DeleteAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "=== Good bye ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItems() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First item"));
        Item second = tracker.add(new Item("Second item"));
        Input in = new StubInput(new String[]{"0", "1"});
        Output output = new StubOutput();
        UserAction[] actions = {new ShowAllItemsAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + first + System.lineSeparator()
                        + second + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Good bye ===" + System.lineSeparator()));
    }

    @Test
    public void findByNameAction() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First item"));
        Item second = tracker.add(new Item("Second item"));
        Item third = tracker.add(new Item("Third item"));
        Input in = new StubInput(new String[]{"0", "Second item", "1"});
        Output output = new StubOutput();
        UserAction[] actions = {new FindByNameAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by name ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + second + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by name ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Good bye ===" + System.lineSeparator()));
    }

    @Test
    public void findByIdAction() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First item"));
        Item second = tracker.add(new Item("Second item"));
        Item third = tracker.add(new Item("Third item"));
        Input in = new StubInput(new String[]{"0", "3", "1"});
        Output output = new StubOutput();
        UserAction[] actions = {new FindByIdAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by Id ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + third + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by Id ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Good bye ===" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[]{"2", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(String.format(
                "Menu.%n"
                        + "0. Exit%n"
                        + "Wrong input, you can select: 0 .. 0%n"
                        + "Menu.%n"
                        + "0. Exit%n"
                        + "=== Good bye ===%n"
                )
        ));
    }
}