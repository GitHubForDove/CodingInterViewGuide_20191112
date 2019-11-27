package CodingInterviewGuide.demo.Chapter2;

import Utils.ListNode;

import java.util.Stack;

/**
 * 将单链表的每K个节点之间排序
 *
 * 给定一个单链表头节点head，实现一个调整单链表的函数，
 * 使得每K个节点之间逆序，如果最后不够K个节点一组，
 * 则不调整最后几个节点。
 */
public class ReverseKNodes {

    public ListNode reverseKNodes(ListNode head, int K) {
        if (K < 2) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == K) {
                pre = resign(stack, pre, next);
                // 第一组 特殊处理 获得头节点
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    /**
     * 将K个节点 翻转 保持前后节点连接不断
     */
    public static ListNode resign(Stack<ListNode> s, ListNode left, ListNode right) {
        ListNode cur = s.pop();
        // 保证前面的节点不断
        if (left != null) {
            left.next = cur;
        }
        ListNode next = null;
        while (!s.isEmpty()) {
            next = s.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }
}
