package design;

import java.util.HashMap;
import java.util.Map;

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
public class LRUCache {

    Map<Integer, Node> cache;
    DoubleLinkedList list;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new DoubleLinkedList();
        this.cache = new HashMap<>();
    }

    public void put(final int key, int value) {
        Node n = new Node(key, value);
        if(cache.containsKey(key)) {
            list.remove(n);
        } else if (cache.size() >= capacity) {
            int k = list.removeTail();
            cache.remove(k);
        }
        list.insertHead(n);
        cache.put(key, n);
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node currentNode = cache.get(key);
        update(key, currentNode);
        return cache.get(key).value;
    }

    private void update(int key, Node n) {
        this.list.remove(n);
        this.list.insertHead(n);
        cache.put(key, n);
    }

    class Node {
        int value, key;
        Node prev, next;
        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        public DoubleLinkedList() {
            this.head = new Node();
            this.tail = new Node();
        }

        public void insertHead(Node n) {
            n.prev = head;
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
        }

        public void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }

        public int removeTail() {
            Node n = tail.prev;
            int key = n.key;
            remove(n);
            return key;
        }
    }





}
