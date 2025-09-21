package com.blessings.corp.blessing.breakfast.breakfastshopfirst.service;

import java.util.*;

class Item {
    String itemId;
    String name;
    String category;
    double price;
    int stock;

    public Item(String itemId, String name, String category, double price, int stock) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}

public class BreakfastShopFirst {
    private static final Map<String, Item> menu = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            String[] parts = input.split(" ", 2);
            String command = parts[0];

            switch (command) {
                case "ADD_ITEM":
                    addItem(parts[1]);
                    break;
                case "ORDER_ITEM":
                    orderItem(parts[1]);
                    break;
                case "RESTOCK_ITEM":
                    restockItem(parts[1]);
                    break;
                case "LIST_AVAILABLE_ITEMS":
                    listAvailableItems();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        scanner.close();
    }

    private static void addItem(String input) {
        String[] parts = input.split(" ", 5);
        String itemId = parts[0];
        String name = parts[1].replace("\"", "");
        String category = parts[2].replace("\"", "");
        double price = Double.parseDouble(parts[3]);
        int stock = Integer.parseInt(parts[4]);

        Item item = menu.get(itemId);
        if (item != null) {
            item.stock += stock;
        } else {
            menu.put(itemId, new Item(itemId, name, category, price, stock));
        }
    }

    private static void orderItem(String input) {
        String itemId = input.trim();
        Item item = menu.get(itemId);

        if (item != null && item.stock > 0) {
            item.stock--;
            System.out.println("Ordered " + item.name);
        } else {
            System.out.println("Item not available");
        }
    }

    private static void restockItem(String input) {
        String[] parts = input.split(" ");
        String itemId = parts[0];
        int quantity = Integer.parseInt(parts[1]);

        Item item = menu.get(itemId);
        if (item != null) {
            item.stock += quantity;
            System.out.println("Restocked " + item.name);
        }
    }

    private static void listAvailableItems() {
        menu.values().stream()
            .filter(item -> item.stock > 0)
            .sorted(Comparator.comparing(i -> i.name))
            .forEach(item -> System.out.println(
                item.name + " - " + item.category + " - $" + item.price + " - " + item.stock + " available"
            ));
    }
}
