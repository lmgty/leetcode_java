package newcoder.jobcode;

/**
 * @author LiuYe
 * @data 2021/3/25
 */
public class LinkedListDemo {
    private static ListNode head = new ListNode();

    public static void main(String[] args) {
        ListNode node10 = new ListNode(10);
        ListNode node9 = new ListNode(9);
        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6);

        sortedInsert(node7);
        sortedInsert(node10);
        sortedInsert(node9);
        sortedInsert(node8);
        System.out.println(head);

    }

    private static void sortedInsert(ListNode node) {
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null && curr.val < node.val) {
            curr = curr.next;
            pre = pre.next;
        }

        if (curr == null) {
            pre.next = node;
        }else {
            pre.next = node;
            node.next = curr;
        }
    }

    private static void removeHead(ListNode head) {
        head = head.next;
    }
}
