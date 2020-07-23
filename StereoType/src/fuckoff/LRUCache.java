package fuckoff;


import java.util.HashMap;
import java.util.Map;

/**
 * LRU
 */
public class LRUCache {

    Map<Integer, Node> map;

    DoubleLinkedList list;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(map.get(key));
        } else {
            if (capacity == list.size) {
                Node node = list.removeLast();
                map.remove(node.key);
            }
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        list.addFirst(newNode);
    }

    class Node {
        public int key, val;
        public Node prev, next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleLinkedList {
        private int size;
        private Node head, tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }
}
