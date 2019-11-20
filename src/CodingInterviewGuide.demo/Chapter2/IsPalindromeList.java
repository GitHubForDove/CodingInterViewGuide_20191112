package CodingInterviewGuide.demo.Chapter2;


import Utils.ListNode;

import java.util.Stack;

/**
 * 给定一个链表的头节点head, 判断一个链表是否是回文结构
 *
 */
public class IsPalindromeList {


    public boolean isPalindromeList1(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 比起第一种方法　要只需要对比一半就可以
     */
    public boolean isPalindromeList2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode right = head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
