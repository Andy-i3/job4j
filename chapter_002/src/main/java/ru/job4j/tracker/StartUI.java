package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    // Инициализация переменных

    private Input input = null;
    private Tracker tracker = null;
    private UserAction[] actions = null;

//    public StartUI(Input input, Tracker tracker, UserAction[] actions) {
//
//
//
//    }

    // Запуск программы

    public static void main(String[] args) {
        Input validate = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateActionItem(),
                new CreateActionEdit(),
                new CreateActionDelete(),
                new CreateActionFindByID(),
                new CreateActionShow(),
                new CreateActionFindByName(),
                new CreateActionExit()
        };
      //  new StartUI().init( input, tracker, actions );
        new StartUI().init(validate, tracker, actions);
    }

    // Вывести на консоль список пунктов меню

    private void showMenu(UserAction[] actions) {
        System.out.println( "Menu." );
        for (int index = 0; index < actions.length; index++) {
            System.out.println( index + ". " + actions[index].name() );
        }
    }


     // Основой цикл программы.

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }


    /**
     * Метод реализует выход из программы.
     */

    public static class CreateActionExit implements UserAction {
        @Override
        public String name() {
            return "Exit";
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {

            return false;
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
            String name = input.askStr( "Введите имя заявки :" );
            String desc = input.askStr( "Введите описание заявки :" );
            Item item = new Item( name, desc );
            tracker.add( item );
            System.out.println( "------------ Новая заявка с getId : " + item.getId() + "-----------" );
            System.out.println( "------------ Новая заявка с getName : " + item.getName() + "-----------" );
            return true;
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */

    public static class CreateActionEdit implements UserAction {
        @Override
        public String name() {
            return "Edit item";
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            String id = input.askStr( "Введите ID заявки :" );
            String name = input.askStr( "Введите имя заявки :" );
            String desc = input.askStr( "Введите описание заявки :" );
            Item item = new Item( name, desc );
            if (tracker.replace( id, item )) {
                System.out.println( "------------ Заявка заменена ----------------" );
            }
            return true;
        }
    }

    /**
     * Метод реализует удаление заявки.
     */

    public static class CreateActionDelete implements UserAction {
        @Override
        public String name() {
            return ("Delete item");
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            String id = input.askStr( "Введите ID заявки :" );
            if (tracker.delete( id )) {
                System.out.println( "------------ Заявка удалена ----------------" );
            } else {
                System.out.println( "------------ Заявка не найдена ----------------" );
            }
            return true;
        }
    }

    /**
     * Метод реализует поиск заявки по ID.
     */

    public static class CreateActionFindByID implements UserAction {
        @Override
        public String name() {
            return "Find item by Id";
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println( "------------ Поиск заявки по ID --------------" );
            String item = input.askStr( "Введите ID заявки :" );
            System.out.println( "------------ Заявка: " + tracker.findById( item ) + " -----------" );
            return true;
        }
    }

    /**
     * Метод показывает все заявки
     */


//    public static class CreateActionShow implements UserAction {
//        @Override
//        public String name() {
//            return "Show all items";
//        }
//
//        @Override
//        public boolean execute(Input input, Tracker tracker) {
//            System.out.println( Arrays.toString( tracker.findAll() ) );
//            return true;
//        }
//    }



    public static class CreateActionShow implements UserAction {
        @Override
        public String name() {
            return "Find all.";
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s %s", item.getId(), item.getName()));
            }
            return true;
        }
    }






    /**
     * Метод реализует поиск по имени заявки
     */


    public static class CreateActionFindByName implements UserAction {
        @Override
        public String name() {
            return "Find items by name";
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            String name = input.askStr( "Введите имя заявки :" );
            Item[] sarrayname = tracker.findByName( name );
            for (int i = 0; i < sarrayname.length; i++) {
                System.out.println( "------------ Заявка: " + sarrayname[i].getId() + " -----------" );
            }
            return true;
        }
    }
}