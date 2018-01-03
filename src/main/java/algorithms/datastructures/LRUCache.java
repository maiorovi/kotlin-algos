package algorithms.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> cache;
    private Node head = null;
    private Node last = null;
    private int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        cache = new HashMap<>(maxSize);
    }

    public int get(int x) {
        if (cache.containsKey(x)) {
            Node n = cache.get(x);
            removeNode(n);
            setHead(x, n.value);

            return n.value;
        }

        return -1;
    }

    private void removeNode(Node n) {
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            last = n.prev;
        }
    }

    private void setHead(int key, int value) {
        if (head != null) {
            Node node = new Node(key, value, null, head);
            head.prev = node;
            head = node;
        } else {
            head = new Node(key, value, null, last);
        }
    }

    public void set(int x, int y) {
        if (cache.containsKey(x)) {
            Node n = cache.get(x);
            removeNode(n);
            setHead(x, n.value);
            cache.put(x, head);
        } else {
            if (cache.size() >= maxSize) {
                cache.remove(last.key);
                removeNode(last);
            }
            setHead(x, y);
            cache.put(x, head);
        }
    }


    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }
    }
}
