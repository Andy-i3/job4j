package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit the Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        String name = input.askStr("Enter name: ");
        System.out.println();
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка заменена");
        } else {
            System.out.println("Заявка не найдена");
        }
        return true;
    }
}
