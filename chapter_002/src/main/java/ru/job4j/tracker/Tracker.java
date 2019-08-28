package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    private static final Random RN = new Random();
    // Массив для хранение заявок.
    private final Item[] items = new Item[100];
    // Указатель ячейки для новой заявки.
    private int position = 0;

    // Метод реализаущий добавление заявки в хранилище
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        int i = 0;
        boolean r = false;
        for (Item E : items) {
            if (E != null && E.getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                r = true;
                break;
            }
            i++;
        }
        return r;

    }

    public Item findById(String id) {

        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public void delete(String id) {

        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i);
                this.position--;
                break;
            }
        }
    }


    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int pos = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[i] = items[i];
                pos++;
            }
        }
        return Arrays.copyOf(result, pos);
    }
}