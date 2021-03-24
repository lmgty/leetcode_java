/**
 * @author LiuYe
 * @data 2021/3/24
 */
public class CircleLinked {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        ListNode list7 = new ListNode(7);
        ListNode list8 = new ListNode(8);
        ListNode list9 = new ListNode(9);
        ListNode list10 = new ListNode(10);
        ListNode list11 = new ListNode(11);
        ListNode list12 = new ListNode(12);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        list7.next = list8;
        list8.next = list9;
        list9.next = list10;
        list10.next = list11;
        list11.next = list12;
        list12.next = list3;

        ListNode entryNode = entryNodeOfLoop(list1);
        System.out.println(entryNode);


    }

    public static ListNode entryNodeOfLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCircle = false;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCircle = true;
                break;
            }
        }
        if (!hasCircle) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
