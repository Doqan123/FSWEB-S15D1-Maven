package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("\n0 - Uygulamayı durdur.\n" +
                    "1 - Eklenmesini istediğiniz elemanları giriniz.\n" +
                    "2 - Çıkarılmasını istediğiniz elemanları giriniz.");
            input = scanner.nextInt();
            scanner.nextLine(); // Geçiş karakterini temizler

            switch (input) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırın):");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;

                case 2:
                    if (groceryList.isEmpty()) {
                        System.out.println("Liste boş, çıkarılacak eleman yok.");
                        break;
                    }
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırın):");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;

                case 0:
                    System.out.println("Uygulama durduruluyor...");
                    break;

                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen 0, 1 veya 2 girin.");
            }
        } while (input != 0);

        scanner.close();
    }

    public static void addItems(String itemsToAdd) {
        String[] splitItems = itemsToAdd.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if (checkItemsInList(item)) {
                System.out.println("Girilen item zaten listede: " + item);
            } else {
                groceryList.add(item);
                System.out.println("Item eklendi: " + item);
            }
        }
        sortItems();
    }

    public static void removeItems(String itemsToRemove) {
        String[] splitItems = itemsToRemove.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if (checkItemsInList(item)) {
                groceryList.remove(item);
                System.out.println("Item kaldırıldı: " + item);
            } else {
                System.out.println("Girilen item listede bulunamadı: " + item);
            }
        }
    }

    public static boolean checkItemsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Mevcut Pazar Listesi: ");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public static void sortItems() {
        Collections.sort(groceryList);
    }
}
