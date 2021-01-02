package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(List.of("0", "Item name", "1"));
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        List<UserAction> actions = List.of(new CreateAction(output), new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(List.of("0", Integer.toString(item.getId()), replacedName, "1"));
        Output output = new StubOutput();
        List<UserAction> actions = List.of(new ReplaceAction(output), new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(List.of("0", Integer.toString(item.getId()), "1"));
        Output output = new StubOutput();
        List<UserAction> actions = List.of(new DeleteAction(output), new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(List.of("0"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Exit(output));
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
        Input in = new StubInput(List.of("0", "1"));
        Output output = new StubOutput();
        List<UserAction> actions = List.of(new ShowAllItemsAction(output), new Exit(output));
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
        Input in = new StubInput(List.of("0", "Second item", "1"));
        Output output = new StubOutput();
        List<UserAction> actions = List.of(new FindByNameAction(output), new Exit(output));
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
        Input in = new StubInput(List.of("0", "3", "1"));
        Output output = new StubOutput();
        List<UserAction> actions = List.of(new FindByIdAction(output), new Exit(output));
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
        Input in = new StubInput(List.of("2", "0"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Exit(output));
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

    @Test
    public void sortByNameUpItem() {
        Tracker trackerOne = new Tracker();
        Item first = trackerOne.add(new Item("orange"));
        Item second = trackerOne.add(new Item("apple"));
        Item third = trackerOne.add(new Item("tomato"));
        List<Item> items = trackerOne.findAll();
        Collections.sort(items, new SortByNameUpItem());
        List<Item> expected = Arrays.asList(second, first, third);
        assertThat(items, is(expected));
    }

    @Test
    public void sortByNameDownItem() {
        Tracker trackerOne = new Tracker();
        Item first = trackerOne.add(new Item("orange"));
        Item second = trackerOne.add(new Item("apple"));
        Item third = trackerOne.add(new Item("tomato"));
        List<Item> items = trackerOne.findAll();
        Collections.sort(items, new SortByNameDownItem());
        List<Item> expected = Arrays.asList(third, first, second);
        assertThat(items, is(expected));
    }
}