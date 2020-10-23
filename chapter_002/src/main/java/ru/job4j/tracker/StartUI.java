package ru.job4j.tracker;


public class StartUI {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAll(Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.getId() + "   " + item.getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {

        System.out.println("=== Edit the Item ====");
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        String name = input.askStr("Enter name: ");
        System.out.println();
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка заменена");
        } else {
            System.out.println("Заявка не найдена");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {

        System.out.println("=== Delele the Item ====");
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка не найдена");
        }
    }

    public static void findItemId(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        Item res = tracker.findById(id);
        if (res == null) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println(res.getId() + "  " + res.getName());
        }
    }

    public static void findItemName(Input input, Tracker tracker) {

        System.out.println("=== Find item by name ====");
        String name = input.askStr("Enter Name: ");
        Item[] arrays = tracker.findByName(name);
        if (arrays.length > 0) {
            for (Item item : arrays) {
                System.out.println(item.getId() + "  " + item.getName());
            }
        } else {
            System.out.println("Заявка с таким name не найдена");
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                StartUI.findItemName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.printf("Menu:\n0. Add new Item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by Id\n5. Find items by name\n6. Exit Program\n%n");
    }
}