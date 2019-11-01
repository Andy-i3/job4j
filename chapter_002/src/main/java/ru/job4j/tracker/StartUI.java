package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {


    private static Input input;
    private static Tracker tracker = null;
    private static UserAction[] actions = null;

    //  Конструктор заявок
    // Input input, Tracker tracker, UserAction[] actions
    public StartUI() {
       StartUI.input = input;
       StartUI.tracker = tracker;
       StartUI.actions = actions;
    }

    private static void show(Input input, Tracker tracker) {
        System.out.println( Arrays.toString( tracker.findAll() ) );
    }

    /**
     * Основой цикл программы.
     */

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateActionItem(),
                new CreateActionEdit(),
                new CreateActionDelete()};

        new StartUI().init(input, tracker, actions);
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select =   Integer.getInteger(input.ask("Select: "));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }


    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */

    public static class CreateActionItem implements UserAction {
        @Override
        public String name() {
            return "Add new Item";
        }
        @Override
        public boolean execute(Input input, Tracker tracker) {
            String name = input.ask( "Введите имя заявки :" );
            String desc = input.ask( "Введите описание заявки :" );
            Item item = new Item( name, desc );
            tracker.add( item );
            System.out.println( "------------ Новая заявка с getId : " + item.getId() + "-----------" );
            System.out.println( "------------ Новая заявка с getName : " + item.getName() + "-----------" );
            return true;
        }
    }



    public static class CreateActionEdit implements UserAction {
        @Override
        public String name() {
            return "Edit item";
        }
        @Override
        public boolean execute(Input input, Tracker tracker) {
            String id = input.ask( "Введите ID заявки :" );
            String name = input.ask( "Введите имя заявки :" );
            String desc = input.ask( "Введите описание заявки :" );
            Item item = new Item( name, desc );
            if (tracker.replace( id, item )) {
                System.out.println( "------------ Заявка заменена ----------------" );
            }
            return true;
        }
    }
    public static class CreateActionDelete implements UserAction {
        @Override
        public String name() {
            return( "Delete item" );
        }
        public boolean execute(Input input, Tracker tracker) {
            String id = input.ask( "Введите ID заявки :" );
            if (tracker.delete( id )) {
                System.out.println( "------------ Заявка удалена ----------------" );
            } else {
                System.out.println( "------------ Заявка не найдена ----------------" );
            }
            return true;
        }
    }

        private static void findbyid(Input input, Tracker tracker) {
            System.out.println( "------------ Поиск заявки по ID --------------" );
            String item = input.ask( "Введите ID заявки :" );
            System.out.println( "------------ Заявка: " + tracker.findById( item ) + " -----------" );
        }

        private static void findbyname(Input input, Tracker tracker) {
            System.out.println( "------------ Поиск заявки по имени --------------" );
            String name = input.ask( "Введите имя заявки :" );
            Item[] sarrayname = tracker.findByName( name );
            for (int i = 0; i < sarrayname.length; i++) {
                System.out.println( "------------ Заявка: " + sarrayname[i].getId() + " -----------" );
            }
        }



    /**
         * Запускт программы.
         */



//        private void showMenu() {
//            String s = String.join( "\n", "Menu", "", "0. Add new Item", "1. Show all items", "2. Edit item", "3. Delete item", "4. Find item by Id", "5. Find items by name", "6. Exit Program", "" );
//            System.out.println( s );
//        }
    }