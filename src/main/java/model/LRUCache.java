package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuYe
 * @date 2021/3/8 12:03 下午
 */
public class LRUCache {
    Map<String, DLinkedNode> cache = new HashMap<>();
    int capacity;
    int count;
    DLinkedNode head, tail;

    public LRUCache(int capacity){
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }


    public String get(String key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return null;
        }
        this.moveToHead(node);
        return node.value;
    }

    public void set(String key, String value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            this.addNode(newNode);
            count++;

            if (count > capacity) {
                DLinkedNode preTail = this.popTail();
                cache.remove(preTail.key);
                count --;
            }
        }else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode preTail = tail.pre;
        this.removeNode(preTail);
        return preTail;
    }

    @Override
    public String toString() {
        DLinkedNode temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp.next.next != null) {
            sb.append(temp.next.value).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set("A","1");
        System.out.println(lruCache);
        lruCache.set("B","2");
        System.out.println(lruCache);
        lruCache.set("C","3");
        System.out.println(lruCache);
        lruCache.set("D","4");
        System.out.println(lruCache);
        lruCache.set("E","5");
        System.out.println(lruCache);
        lruCache.set("F","6");
        System.out.println(lruCache);
        lruCache.get("D");
        System.out.println(lruCache);
        lruCache.get("F");
        System.out.println(lruCache);
        lruCache.get("E");
        System.out.println(lruCache);
        lruCache.get("H");
        System.out.println(lruCache);

    }

}

class DLinkedNode {
    String key;
    String value;
    DLinkedNode pre;
    DLinkedNode next;
}