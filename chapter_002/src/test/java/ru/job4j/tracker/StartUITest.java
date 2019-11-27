package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

     // Меню
    private final UserAction[] action = {
            new StartUI.CreateActionItem(),
            new StartUI.CreateActionEdit(),
            new StartUI.CreateActionDelete(),
            new StartUI.CreateActionFindByID(),
            new StartUI.CreateActionShow(),
            new StartUI.CreateActionFindByName(),
            new StartUI.CreateActionExit()
    };


    // Проверка создания заявки

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI().init(input, tracker, action);     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    // Проверка редактирования заявки

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"1", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI().init(input, tracker, action);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    // Проверка удаления заявки

    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI().init(input, tracker, action);    //   создаём StartUI и вызываем метод init()
        assertThat(tracker.delete(tracker.findAll()[0].getId()), is(true));
    }

    // Проверка выхода

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));

        System.setOut(def);
    }

        @Test
        public void whenCheckOutput() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream def = System.out;
            System.setOut( new PrintStream( out ) );
            Tracker tracker = new Tracker();
            Item item = new Item( "fix bug" );
            tracker.add( item );
            StartUI.CreateActionShow act = new StartUI.CreateActionShow();
            act.execute(new StubInput(new String[] {"fix bug"}), tracker);
            String expect = new StringJoiner( System.lineSeparator(), "", System.lineSeparator() )
                    .add( item.getId() + " " + item.getName() )
                    .toString();
            assertThat( new String(out.toByteArray()), is(expect) );
            System.setOut( def );
        }
}