package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] arrays = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName() == key) arrays[count++] = item;
        }
        return Arrays.copyOf(arrays, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public void replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
        item.setId(items[index].getId());
        items[index] = item; }
    }
}