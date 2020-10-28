package ru.job4j.tracker;

public class FindItemNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter Name: ");
        Item[] arrays = tracker.findByName(name);
        if (arrays.length > 0) {
            for (Item item : arrays) {
                System.out.println(item.getId() + "  " + item.getName());
            }
        } else {
            System.out.println("Заявка с таким name не найдена");
        }
        return true;
    }
}
