package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

/**
 * 反转部分单链表
 * 题目：
 *    给定一个单向链表的头结点head，以及两个整数from 和 to ，
 *    在单链表上把第from个节点到第to个节点这一部分进行反转
 */
public class ReversePart {


    public static ListNode reversePart(ListNode head, int from, int to) {
        ListNode p = head;
        ListNode pre = null;
        ListNode pos = null;
        int len = 0;
        // 先计算　from对应下标前一个节点的位置 与　pos后面一个节点的位置
        while (p != null) {
            len++;
            pre = len == from-1 ? p : pre;
            pos = len == to+1 ? p : pos;
            p = p.next;
        }

        // 边界判断　
        if (from > to || from < 1 || to > len) {
            return head;
        }

        p = pre == null ? head : pre.next;
        ListNode q = p.next;
        p.next = pos;
        ListNode next = null;
        while (q != pos) {
            next = q.next;
            q.next = p;
            p = q;
            q = next;
        }

        if (pre != null) {
            pre.next = p;
            return head;
        }

        return p;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6};
        ListNode head = GenerationListUtils.generationList(nums);
        ListNode res = reversePart(head, 2, 4);
        while (res != null) {
            System.out.println(res.val + ",");
            res = res.next;
        }
    }

}
