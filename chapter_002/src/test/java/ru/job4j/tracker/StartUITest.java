package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }


    @Test
    public void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = {tracker.add(new Item("New item 1")), tracker.add(new Item("New item 2"))};
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find all" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find all ====" + System.lineSeparator()
                + "1   New item 1" + System.lineSeparator()
                + "2   New item 2" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find all" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "==== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = {tracker.add(new Item("New item 1")), tracker.add(new Item("New item 1"))};
        Input in = new StubInput(
                new String[] {"0", "New item 1", "1"}
        );
        UserAction[] actions = {
                new FindItemNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by name ====" + System.lineSeparator()
                + "1  New item 1" + System.lineSeparator()
                + "2  New item 1" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "==== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindItemIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);


        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ====" + System.lineSeparator()
                + "1  Find item" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "==== Exit ====" + System.lineSeparator()));

        assertThat(tracker.findById(3), is(nullValue()));

    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                                + "==== Exit ====%n"
                )
        ));
    }
}