package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */


    private static Input input;

    /**
     * Хранилище заявок.
     */
    private static Tracker tracker = null;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        StartUI.input = input;
        StartUI.tracker = tracker;
    }

    private static void show(Input input, Tracker tracker) {
        System.out.println( Arrays.toString( tracker.findAll() ) );
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = input.ask( "Введите пункт меню : " );
            if (ADD.equals( answer )) {
                StartUI.createItem( input, tracker );
            } else if (SHOW.equals( answer )) {
                StartUI.show( input, tracker );
            } else if (EDIT.equals( answer )) {
                StartUI.edit( input, tracker );
            } else if (DELETE.equals( answer )) {
                StartUI.delete( input, tracker );
            } else if (FINDBYID.equals( answer )) {
                StartUI.findbyid( input, tracker );
            } else if (FINDBYNAME.equals( answer )) {
                StartUI.findbyname( input, tracker );
            } else if (EXIT.equals( answer )) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
//    private static void createItem(Input input, Tracker tracker) {
//        System.out.println("------------ Добавление новой заявки --------------");
//        String name = input.ask("Введите имя заявки :");
//        String desc = input.ask("Введите описание заявки :");
//        Item item = new Item(name, desc);
//        tracker.add(item);
//        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
//        System.out.println("------------ Новая заявка с getName : " + item.getName() + "-----------");
//    }


    public class CreateActionItem implements UserAction {
        @Override
        public String name() {
            return "------------ Добавление новой заявки --------------";
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

//    private static void edit(Input input, Tracker tracker) {
//        System.out.println("------------ Редактирование заявки --------------");
//        String id = input.ask("Введите ID заявки :");
//        String name = input.ask("Введите имя заявки :");
//        String desc = input.ask("Введите описание заявки :");
//        Item item = new Item(name, desc);
//        if (tracker.replace(id, item)) {
//            System.out.println("------------ Заявка заменена ----------------");
//        }
//    }

    public class CreateActionEdit implements UserAction {
        @Override
        public String name() {
            return "------------ Редактирование заявки --------------";
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


//    private static void delete(Input input, Tracker tracker) {
//        System.out.println("------------ Удаление заявки по ID --------------");
//        String id = input.ask("Введите ID заявки :");
//        if (tracker.delete(id)) {
//            System.out.println("------------ Заявка удалена ----------------");
//        } else {
//            System.out.println("------------ Заявка не найдена ----------------");
//        }
//    }

    public class CreateActionDelete implements UserAction {
        @Override
        public String name() {
            return( "------------ Удаление заявки по ID --------------" );
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

        public static void main(String[] args) {
            new StartUI( new ConsoleInput(), new Tracker() ).init();
        }

        private void showMenu() {
            String s = String.join( "\n", "Menu", "", "0. Add new Item", "1. Show all items", "2. Edit item", "3. Delete item", "4. Find item by Id", "5. Find items by name", "6. Exit Program", "" );
            System.out.println( s );
        }
    }