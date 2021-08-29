package design;

import java.util.HashMap;
import java.util.Map;

/*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

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
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.list = new DoubleLinkedList();
    }

    public void put(final int key, final int value) {
        Node node = new Node(key, value);
        if(cache.size() >= capacity) {
            int oldKey = list.removeTail();
            cache.remove(oldKey);
        } else if (cache.containsKey(key)) {
            list.removeNode(node);
        }
        list.insertNode(node);
        cache.put(key, node);
    }

    public int get(final int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        this.update(key, node);
        return node.val;
    }

    private void update(int key, Node node) {
        list.removeNode(node);
        list.insertNode(node);
        cache.put(key, node);
    }

    class DoubleLinkedList {
        Node head, tail;
        public DoubleLinkedList() {
            this.head = new Node();
            this.tail = new Node();
        }

        public void insertNode(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        public int removeTail() {
            Node node = tail.prev;
            int key = node.key;
            removeNode(node);
            return key;
        }
    }

    class Node {
        int key, val;
        Node prev, next;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
