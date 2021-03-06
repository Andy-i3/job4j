package ru.job4j.tracker;

public class FindItemNameAction implements UserAction {


    private final Output out;
    public FindItemNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ====");
        String name = input.askStr("Enter Name: ");
        Item[] arrays = tracker.findByName(name);
        if (arrays != null) {
            for (Item item : arrays) {
                out.println(item.getId() + "  " + item.getName());
            }
        } else {
            out.println("Заявка с таким name не найдена");
        }
        return true;
    }
}
