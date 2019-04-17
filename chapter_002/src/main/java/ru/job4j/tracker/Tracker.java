package ru.job4j.tracker;
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

    public void replace(String id, Item item) {
        int i = 0;
        for (Item E : items) {
            if (E != null && E.getId().equals(id)) {
                this.items[i] = item;
            }
            i++;
        }
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

    // public delete(String id) {
    // Item[findById(id)].remove;
    //   }
    //  public Item[] findAll() {
//
    //  }

    public Item findByName(String key) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result = item;
                break;
            }
        }
        return result;
    }
}