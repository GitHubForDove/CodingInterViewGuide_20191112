package CodingInterviewGuide.demo.Chapter2;


import Utils.ListNode;

/**
 * 判断一个链表是否有环, 如果有返回第一个相交节点，不相交则返回null
 */
public class getLoopNode {

    public ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode n1 = head.next; // n1--> slow
        ListNode n2 = head.next.next; // n2 --> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
