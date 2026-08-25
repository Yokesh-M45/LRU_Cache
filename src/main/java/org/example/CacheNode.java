package org.example;

public class CacheNode {

    int key;
    String value;

    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, String value) {
        this.key = key;
        this.value = value;
    }
}