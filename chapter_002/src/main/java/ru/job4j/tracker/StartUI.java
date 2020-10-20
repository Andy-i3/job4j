package ru.job4j.tracker;


public class StartUI {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            // System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getId() + "   " + item.getName());
                }

            } else if (select == 2) {

                System.out.println("=== Edit the Item ====");
                int id = Integer.parseInt(input.askStr("Enter ID: "));
                String name = input.askStr("Enter name: ");
                System.out.println();
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка заменена");
                } else {
                    System.out.println("Заявка не найдена");
                }

            } else if (select == 3) {
                System.out.println("=== Delele the Item ====");
                int id = Integer.parseInt(input.askStr("Enter ID: "));
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена");
                } else  {
                    System.out.println("Заявка не найдена");
                }

            } else if (select == 4) {

                System.out.println("=== Find item by Id ====");
                int id = Integer.parseInt(input.askStr("Enter ID: "));
                Item res = tracker.findById(id);
                if (res == null) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println(res.getId() + "  " + res.getName());
                }
            } else if (select == 5) {

                System.out.println("=== Find item by name ====");
                String name = input.askStr("Enter Name: ");
                Item[] arrays = tracker.findByName(name);
                if (arrays != null) {
                for (Item item: arrays) {
                    System.out.println(item.getId() + "  " + item.getName());
                     }
                } else {
                    System.out.println("Заявка с таким name не найдена");
                }


            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.printf("Menu:\n0. Add new Item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by Id\n5. Find items by name\n6. Exit Program\n%n");
    }
}