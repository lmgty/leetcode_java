package newcoder;

/**
 * @author LiuYe
 * @date 2021/3/14 9:27 下午
 */
public class NC33 {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while (l1 != null && l2!= null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }
}
