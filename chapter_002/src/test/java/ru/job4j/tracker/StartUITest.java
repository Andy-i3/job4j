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
                new String[] {"0", "1", "New item name" , "1"}
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
                new String[] {"0", "1" , "1"}
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
        Item[] items = {tracker.add(new Item("New item 1")),tracker.add(new Item("New item 2"))};
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu.\r\n" +
                "0. Find all\r\n" +
                "1. Exit\r\n" +
                "=== Find all ====\r\n" +
                "1   New item 1\r\n" +
                "2   New item 2\r\n" +
                "Menu.\r\n" +
                "0. Find all\r\n" +
                "1. Exit\r\n" +
                "==== Exit ====\r\n"  ));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = {tracker.add(new Item("New item 1")),tracker.add(new Item("New item 1"))};
        Input in = new StubInput(
                new String[] {"0", "New item 1", "1"}
        );
        UserAction[] actions = {
                new FindItemNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is ("Menu.\r\n" +
        "0. Find item by name\r\n" +
        "1. Exit\r\n" +
                "=== Find item by name ====\r\n" +
        "1  New item 1\r\n" +
        "2  New item 1\r\n" +
        "Menu.\r\n" +
        "0. Find item by name\r\n" +
        "1. Exit\r\n" +
                "==== Exit ====\r\n"
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", "1" , "1"}
        );
        UserAction[] actions = {
                new FindItemIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);


        assertThat(output.toString(), is("Menu.\r\n" +
        "0. Find item by Id\r\n" +
        "1. Exit\r\n" +
                "=== Find item by Id ====\r\n" +
        "1  Find item\r\n" +
        "Menu.\r\n" +
        "0. Find item by Id\r\n" +
        "1. Exit\r\n" +
                "==== Exit ====\r\n"));

        assertThat(tracker.findById(3), is(nullValue()));

    }
}