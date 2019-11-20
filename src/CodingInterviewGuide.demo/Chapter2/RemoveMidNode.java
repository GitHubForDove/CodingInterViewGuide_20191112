package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

/**
 * 删除链表中间结点
 */
public class RemoveMidNode {



    /**
     * 思路：
     *
     *  1、如果链表为空 或者 链表为1， 不需要调整 直接返回
     *  2、如果链表为2，将头结点删除即可
     *  3、当链表为3 则应删除第二个结点 当链表为4 则删除第2个结点  当链表为5时 删除第3个结点
     */
    public static ListNode removeMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = pre.next.next;
        while (cur.next != null && cur.next.next != null) {
            // 向前移动一个位置
            pre = pre.next;
            // 每次向后移动两个位置
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        ListNode head = GenerationListUtils.generationList(nums);
        ListNode res = removeMidNode(head);
        while (res != null) {
            System.out.println(res.val + ",");
            res = res.next;
        }
    }


}
