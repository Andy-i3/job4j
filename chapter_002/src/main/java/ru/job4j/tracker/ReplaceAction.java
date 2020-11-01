package ru.job4j.tracker;

public class ReplaceAction implements UserAction{

    private final Output out;
    public ReplaceAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "Edit the Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit the Item ====");
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        String name = input.askStr("Enter name: ");
        out.println("");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка заменена");
        } else {
            out.println("Заявка не найдена");
        }
        return true;
    }
}
