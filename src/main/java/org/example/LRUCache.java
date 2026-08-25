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

        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Put Key-Value
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            CacheNode node = map.get(key);

            node.value = value;

            removeNode(node);
            addToFront(node);
        } else {

            CacheNode node = new CacheNode(key, value);

            map.put(key, node);
            addToFront(node);

            if (map.size() > capacity) {
                CacheNode last = tail.prev;

                removeNode(last);
                map.remove(last.key);
            }
        }
    }

    // Get Value
    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        CacheNode node = map.get(key);

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
            System.out.println("Cache is empty");
            return;
        }

        CacheNode current = head.next;

        System.out.println("Cache:");

        while (current != tail) {
            System.out.println(
                    "Key: " + current.key +
                            " | Value: " + current.value
            );

            current = current.next;
        }
    }

    // Cache Size
    public int size() {
        return map.size();
    }

    private void addToFront(CacheNode node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(CacheNode node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
