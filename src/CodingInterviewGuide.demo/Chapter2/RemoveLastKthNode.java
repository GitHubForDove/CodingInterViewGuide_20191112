package CodingInterviewGuide.demo.Chapter2;


/**
 * 在单链表和双链表中删除倒数第Ｋ个节点
 */
public class RemoveLastKthNode {

    public class ListNode {
        int  val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  思路：
     *      1、头结点为null 或 k比链表的长度要大  不存在该节点 直接返回
     *      2、第k个节点 正好是 头结点 直接返回head.next
     *      3、第K个节点是最后一个节点 删除最后一个节点即可
     *      4、 删除节点 需要知道第N-K个节点的位置
     */
    public ListNode removeLastKthNode(ListNode head, int k) {
        if (head == null || k<1) {
            return head;
        }

        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            head = head.next;
        }

        if (k < 0) {
            cur = head;
            // 用++k　所以指针停在第ｋ个节点的前一个位置
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        return head;
    }
}
