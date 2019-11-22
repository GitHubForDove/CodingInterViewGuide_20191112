package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

/**
 * 将单链表按某值划分成左边小、中间等、右边大的形式
 *
 * 题目：
 *      给定一个单向链表的头节点head， 结点的值类型是整形，再给定一个整数pivot。
 *      实现一个调整链表的函数，将链表调整为左边部分都小于pivot的结点，中间部分都是值
 *      等于pivot的结点，右边都是大于pivot的结点。
 *      除这个外，对调整后的结点顺序没有更多的要求。
 */
public class ListPartition {

    /**
     * 思路：
     *  1、先遍历一遍链表，得到链表的长度N
     *  2、生成一个长度为N的ListNode类型的数组，然后遍历一遍链表，将结点依次放进nodeArr中。
     *  3、把nodeArr中小于pivot的结点放在左边，把相等的放中间，把大于的放右边。
     *  4、把nodeArr中的结点依次进行连接起来即可。
     */
    public ListNode listPartition(ListNode head, int pivot) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode[] nodeArr = new ListNode[len];
        cur = head;
        int i=0;
        for (i=0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        int right = nodeArr.length;
        for (i=1; i != nodeArr.length; i++) {
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i -1].next = null;
        return nodeArr[0];

    }


    public void arrPartition(ListNode[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].val == pivot) {
                index++;
            } else {
                swap(nodeArr, index, --big);
            }
        }

    }

    public void swap(ListNode[] nodeArr, int i, int j) {
        ListNode temp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = temp;
    }

    /**
     * 第二种方法 进阶
     */
    public static ListNode listPartition2(ListNode head, int privot) {
        ListNode sH = null; // 小的头
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next = null;
        // 所有的节点分进三个链表中
        while (head != null) {
            next = head.next;
            head.next = null;

            if (head.val < privot) {
                if (sH == null) {
                     sH = head;
                     sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == privot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // 小的和相等的相连
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{9,0,4,5,1,6,8,4,4,5,4};
        int pivot = 4;
        ListNode head = GenerationListUtils.generationList(nums);
        ListPartition listPartition = new ListPartition();
        ListNode res = listPartition.listPartition2(head, pivot);
        while (res != null) {
            System.out.println(res.val + ",");
            res = res.next;
        }
    }
}
