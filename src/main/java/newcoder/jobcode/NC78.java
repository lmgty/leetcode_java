package newcoder.jobcode;

/**
 * @author LiuYe
 * @data 2021/3/11
 */
public class NC78 {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
