package ru.job4j.tracker;

public class FindItemIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        Item res = tracker.findById(id);
        if (res == null) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println(res.getId() + "  " + res.getName());
        }
        return true;
    }
}
