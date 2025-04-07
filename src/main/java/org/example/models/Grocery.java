package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLütfen bir işlem seçin: ");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün çıkar");
            System.out.println("0 - Çıkış");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (örn: tomato, orange, peach):");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case "2":
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (örn: tomato, orange, peach):");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
                case "0":
                    System.out.println("Uygulama durduruldu.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz giriş, lütfen 0, 1 veya 2 giriniz.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            item = item.trim();

            if (!groceryList.contains(item)) {
                groceryList.add(item);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        if (input == null || input.isBlank()) return;

        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (checkItemIsInList(trimmed)) {
                groceryList.remove(trimmed);
            }
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        groceryList.sort(String::compareTo);

        for (String item: groceryList) {
            System.out.println(item);
        }
    }
}
