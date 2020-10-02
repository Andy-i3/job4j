package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    @SuppressWarnings("checkstyle:RightCurly")
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getId() + "   " + item.getName());
                }

            } else if (select == 2) {

                System.out.println("=== Edit the Item ====");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.println();
                Item item = new Item();
                item.setName(name);
                tracker.replace(id, item);

            } else if (select == 3) {
                System.out.println("=== Delele the Item ====");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                tracker.delete(id);

            } else if (select == 4) {

                System.out.println("=== Find item by Id ====");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                String res = tracker.findById(id).getName();
                if (res == null) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println(res);
                }
            } else if (select == 5) {

                System.out.println("=== Find item by name ====");
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
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