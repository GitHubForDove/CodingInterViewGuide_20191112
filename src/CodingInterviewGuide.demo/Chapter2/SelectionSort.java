package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

/**
 * 单链表的选择排序
 *
 * 题目：
 * 给定一个无序单链表的头节点head，实现单链表的选择排序。
 * 要求：额外空间复杂度为O(1)
 */
public class SelectionSort {

    public static ListNode selectionSort(ListNode head) {
        ListNode cur = head;
        ListNode pre = head;
        ListNode small = head;
        ListNode smallPre = null;
        ListNode tail = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallLestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            // 确定当前节点是否是最小的那个节点 如果是最小的那个节点
            cur = cur == small ? cur.next : cur;

            // 如果tail ！= null 最小的那个加到tail的后面
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }

        return null;
    }

    /**
     * 获取链表中最小的节点 前一个节点
     */
    public static ListNode getSmallLestPreNode(ListNode head) {
        ListNode smallPre = null;
        ListNode pre = head;
        ListNode small = head;
        ListNode cur = head.next;
        while (cur != null) {

            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }

        return smallPre;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,3,7,1,2,4,5};
        ListNode head = GenerationListUtils.generationList(nums);
        //ListNode small = getSmallLestPreNode(head);
        //System.out.println(small.val);
    }
}
