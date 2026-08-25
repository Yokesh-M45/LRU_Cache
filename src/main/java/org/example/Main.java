package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Cache Capacity: ");
        int capacity = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        while (true) {

            System.out.println("\n===== LRU CACHE =====");
            System.out.println("1. Put Key-Value");
            System.out.println("2. Get Value");
            System.out.println("3. Remove Key");
            System.out.println("4. Display Cache");
            System.out.println("5. Check Cache Size");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Key: ");
                    int key = sc.nextInt();

                    System.out.print("Enter Value: ");
                    String value = sc.next();

                    cache.put(key, value);

                    System.out.println("Key-Value added successfully.");

                    break;

                case 2:

                    System.out.print("Enter Key: ");
                    key = sc.nextInt();

                    String result = cache.get(key);

                    if (result == null) {
                        System.out.println("Key not found.");
                    } else {
                        System.out.println("Value: " + result);
                    }

                    break;

                case 3:

                    System.out.print("Enter Key: ");
                    key = sc.nextInt();

                    cache.remove(key);

                    System.out.println("Key removed successfully.");

                    break;

                case 4:

                    cache.display();

                    break;

                case 5:

                    System.out.println(
                            "Cache Size: " + cache.size()
                    );

                    break;

                case 6:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}