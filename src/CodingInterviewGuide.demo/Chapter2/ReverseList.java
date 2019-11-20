package CodingInterviewGuide.demo.Chapter2;


import Utils.ListNode;

/**
 * 翻转单链表
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
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
