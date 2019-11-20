package CodingInterviewGuide.demo.Chapter2;


import Utils.DoubleListNode;
import Utils.ListNode;

/**
 * 反转双端链表
 */
public class ReverseDoubleList {



    public DoubleListNode reverseList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre.last = head;
            pre = head;
            head = next;
        }
        return pre;
    }
}
