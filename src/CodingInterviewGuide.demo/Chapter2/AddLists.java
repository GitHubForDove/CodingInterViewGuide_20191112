package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 */
public class AddLists {

    public ListNode addLists(ListNode head1, ListNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (head1 != null) {
            s1.add(head1.val);
            head1 = head1.next;
        }

        while (head2 != null) {
            s2.add(head2.val);
            head2 = head2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;

        ListNode node = null;
        ListNode pre = null;
        while (!s1.empty() || !s2.empty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return node;
    }


    /**
     * 第二种 解法
     * 利用链表的逆序求解，可以节省用栈的空间
     * 思路：将链表先进行反转，然后 按照超过个位就进位的思路 生成一个新的链表 返回头节点
     */
    public ListNode addLists2(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        ListNode c1 = head1;
        ListNode c2 = head2;
        ListNode node = null;
        ListNode pre = null;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = ca + n1 + n2;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }

        if (ca == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        //reverseList(head1);
        //reverseList(head2);
        return node;
    }

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

    public static void main(String[] args) {
        int[] arr1 = new int[]{9,3,7};
        int[] arr2 = new int[]{6,3};

        ListNode list1 = GenerationListUtils.generationList(arr1);
        ListNode list2 = GenerationListUtils.generationList(arr2);
        AddLists addLists = new AddLists();
        ListNode res = addLists.addLists2(list1, list2);

        while (res != null) {
            System.out.println(res.val + ",");
            res = res.next;
        }
    }
}
