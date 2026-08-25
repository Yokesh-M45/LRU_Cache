package org.example;

public class CacheNode {

    int key;
    int value;

    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}