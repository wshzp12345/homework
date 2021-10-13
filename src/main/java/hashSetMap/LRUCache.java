package hashSetMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Node head;
    private Node tail;
    private int max;
    private int length;
    private Map<Integer, Node> cache;
    public LRUCache(int capacity) {
        this.max = capacity;
        length = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node cur = cache.get(key);
            remove(cur);
            insert(head,cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node cur = cache.get(key);
            remove(cur);
            insert(head,cur);
            cur.val = value;

        } else {
            Node cur = new Node(value,key);
            insert(head,cur);
            cache.put(key, cur);
            length++;
            if(length > max) {
                Node last = tail.pre;
                remove(last);
                length --;
                cache.remove(last.key);
            }
        }
    }
    private void remove (Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void insert(Node before, Node node) {
        before.next.pre = node;
        node.next=before.next;
        before.next = node;
        node.pre = before;
    }
}

class Node {
    int val;
    int key;

    Node next;
    Node pre;
    Node(){

    }
    Node (int val, int key) {
        this.key = key;
        this.val = val;
    }
}