package ru.job4j.tracker;

public class FindAllAction implements UserAction{

    private final Output out;
    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all ====");
        for (Item item : tracker.findAll()) {
            out.println(item.getId() + "   " + item.getName());
        }
        return true;
    }
}
