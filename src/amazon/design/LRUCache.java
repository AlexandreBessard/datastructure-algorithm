package amazon.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/interview/card/amazon/81/design/478/
public class LRUCache {
    /*
    Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
     */

    class DLinkedList {
        int value;
        int key;
        DLinkedList next, prev;
    }

    private int capacity;
    private DLinkedList head, tail;
    private int size = 0;
    Map<Integer, DLinkedList> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        DLinkedList head = new DLinkedList();
        DLinkedList tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    private void remove(DLinkedList node) {
        DLinkedList next = node.next;
        DLinkedList prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void moveToHead(DLinkedList node) {
        remove(node);
        moveToHead(node);
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private DLinkedList popTail(){
        DLinkedList node = tail.prev;
        remove(node);
        return node;
    }

    private void addNode(DLinkedList node) {
        node.next = this.head.next;
        node.prev = this.head;

        this.head.next.prev = node;
        this.head.next = node;
    }

    public void put(int key, int value) {
        //popTail
        DLinkedList node = cache.get(key);
        if (node == null) {
            node = new DLinkedList();
            node.value = value;
            node.key = key;
            cache.put(key, node);
            addNode(node);
            size++;
            if (size > capacity) {
                cache.remove(popTail().key);
                size--;
            }
        } else {
            //Exist
            node.value = value;
            cache.put(key, node);
            moveToHead(node);
        }
    }
}
