/**
 * @author LiuYe
 * @data 2021/3/4
 */
public class Q92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseBetween(head, 1, 3);
        System.out.println();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode tail = pre;
        for (int i = 0; i < right - left + 1; i++) {
            tail = tail.next;
        }

        ListNode leftNode = pre.next;
        ListNode next = tail.next;

        ListNode[] list = reverseList(leftNode, tail);
        pre.next = list[0];
        list[1].next = next;
        return dummyNode.next;

    }

    private static ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != tail) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;
        return new ListNode[] {tail, head};
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

