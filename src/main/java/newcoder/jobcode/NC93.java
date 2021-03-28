package newcoder.jobcode;

import java.util.*;

/**
 * @author LiuYe
 * @data 2021/3/11
 */
public class NC93 {

    private static Map<Integer, DLinkedNode> cache = new HashMap<>();
    private static int count;
    private static int capacity;
    private static DLinkedNode head, tail;

    public static void main(String[] args) {
        int[][] operators = {
                {1,1,1},
                {1,2,2},
                {1,3,2},
                {2,1},
                {1,4,4},
                {2,2},
        };
        int[] nums = LRU(operators,3);
        System.out.println(Arrays.toString(nums));

    }
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU(int[][] operators, int k) {
        // write code here
        capacity = k;
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.pre = head;
        List<Integer> res = new ArrayList<>();


        int n = operators.length;

        for (int[] operator : operators) {
            if (operator[0] == 1) {
                set(operator[1], operator[2]);
            } else {
                res.add(get(operator[1]));
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;

    }

    private static int get(Integer key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private static void set(Integer key, Integer value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            count++;
            if (count > capacity) {
                DLinkedNode lastNode = popLastNode();
                count--;
                assert lastNode != null;
                cache.remove(lastNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private static DLinkedNode popLastNode() {
        DLinkedNode lastNode = tail.pre;
        removeNode(lastNode);
        return lastNode;
    }

    private static void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private static void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private static void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }


    private static class DLinkedNode {
        Integer key;
        Integer value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
