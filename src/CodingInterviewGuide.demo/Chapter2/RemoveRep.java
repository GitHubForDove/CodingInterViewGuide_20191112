package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

import java.util.HashSet;

/**
 * 删除无序单链表中值重复出现的节点
 */
public class RemoveRep {

    /**
     * 给定一个无序单链表的头节点head，删除其中值重复出现的节点
     */
    public static ListNode removeRep1(ListNode head) {

        if (head == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode pre = head;
        ListNode cur = head.next;
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * 类似与插入排序  先找到第一个节点  然后看后面有没有相同的节点 如果有相同的节点 就都进行删除
     * 然后继续向后找第二个节点 依次类推 直到最后一个节点
     */
    public void removeRep(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.val == next.val) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,4,2,1,1};
        ListNode head = GenerationListUtils.generationList(arr);
        ListNode res = removeRep1(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
