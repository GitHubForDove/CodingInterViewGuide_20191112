package CodingInterviewGuide.demo.Chapter2;


import java.util.HashMap;

/**
 * 赋值含有随机指针结点的链表
 *  给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 *  要求返回这个链表的深拷贝。
 */
public class CopyListWithRand {

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode rand;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用 map解决复制问题
     */
    public ListNode copyListWithRand(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;

        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }


}
