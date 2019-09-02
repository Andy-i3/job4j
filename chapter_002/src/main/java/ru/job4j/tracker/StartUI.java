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
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.show();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findbyid();
            } else if (FINDBYNAME.equals(answer)) {
                this.findbyname();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        System.out.println("------------ Новая заявка с getName : " + item.getName() + "-----------");
    }

    private void show() {
        System.out.println(Arrays.toString(this.tracker.findAll()));
    }

    private void edit() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item) == true) {
            System.out.println("------------ Заявка заменена ----------------");
        }
    }

    private void delete() {
        System.out.println("------------ Удаление заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка удалена ----------------");
        } else {
            System.out.println("------------ Заявка не найдена ----------------");
        }
    }

    private void findbyid() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String item = this.input.ask("Введите ID заявки :");
        System.out.println("------------ Заявка: " + this.tracker.findById(item) + " -----------");
    }

    private void findbyname() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] sarray_name = this.tracker.findByName(name);
        for (Item item : sarray_name) {
            System.out.println("------------ Заявка: " + item.getId() + " -----------");
        }
    }


    private void showMenu() {
        String s = String.join("\n", "Menu", "", "0. Add new Item", "1. Show all items", "2. Edit item", "3. Delete item", "4. Find item by Id", "5. Find items by name", "6. Exit Program", "");
        System.out.println(s);
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}