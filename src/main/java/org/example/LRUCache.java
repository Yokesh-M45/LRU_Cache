package org.example;

import java.util.HashMap;

public class LRUCache {

    private int capacity;

    private HashMap<Integer, CacheNode> map;

    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new CacheNode(0, "");
        tail = new CacheNode(0, "");

        head.next = tail;
        tail.prev = head;
    }

    // Put Key-Value
    public void put(int key, String value) {

        // If key already exists
        if (map.containsKey(key)) {

            CacheNode node = map.get(key);

            node.value = value;

            removeNode(node);
            addToFront(node);

        } else {

            CacheNode node = new CacheNode(key, value);

            map.put(key, node);

            addToFront(node);

            // Remove least recently used item
            if (map.size() > capacity) {

                CacheNode lruNode = tail.prev;

                removeNode(lruNode);

                map.remove(lruNode.key);
            }
        }
    }

    // Get Value
    public String get(int key) {

        if (!map.containsKey(key)) {
            return null;
        }

        CacheNode node = map.get(key);

        // Make it recently used
        removeNode(node);
        addToFront(node);

        return node.value;
    }

    // Remove Key
    public void remove(int key) {

        if (map.containsKey(key)) {

            CacheNode node = map.get(key);

            removeNode(node);

            map.remove(key);
        }
    }

    // Display Cache
    public void display() {

        if (map.isEmpty()) {
            System.out.println("Cache is empty.");
            return;
        }

        CacheNode current = head.next;

        System.out.println("\nCache (LRU -> MRU):");

        while (current != tail) {

            System.out.println(
                    "Key: " + current.key +
                            " | Value: " + current.value
            );

            current = current.next;
        }
    }

    // Check Cache Size
    public int size() {
        return map.size();
    }

    // Add node at front
    private void addToFront(CacheNode node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node
    private void removeNode(CacheNode node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}