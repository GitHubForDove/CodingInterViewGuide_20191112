package CodingInterviewGuide.demo.Chapter2;


import Utils.ListNode;

/**
 * 向有序的环形单链表中插入新节点
 *
 * 题目：
 *  一个环形单链表从头节点head开始不降序，同时由最后的节点指回头节点。
 *  给定这样一个环形单链表的头节点head和一个整数num，
 *  请生成节点值为num的新节点，并插入到这个环形链表中，保证调整后的链表依然有序。
 */
public class InsertNum {

    /**
     * 思路：
     *  1、如果头节点为null， 那么将节点插入 再自己指向自己
     *  2、一般情况就是 给定一个pre节点和 一个cur节点，然后去遍历链表 知道找到比num大的节点，然后将将生成的节点插入到这个节点之后。
     *  3、如果遍历了一圈 仍然没有找到  说明num 比所有的节点的值都要大 ，直接插入到头节点之前。
     */
    public ListNode insertNum(ListNode head, int num) {
        ListNode node = new ListNode(num);
        if (head == null) {
            node.next = node;
            return node;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.val <= num && cur.val >= num) {
                node.next = pre.next;
                pre.next = node;
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        return head.val < num ? head : node;

    }

}
