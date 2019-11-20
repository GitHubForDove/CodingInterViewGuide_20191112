package CodingInterviewGuide.demo.Chapter2;


/**
 * 删除双链表的倒数第K个结点
 */
public class RemoveLastKthNode_DoubleNode {

    public class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int val) {
            this.val = val;
        }
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }

        DoubleNode cur = head;

        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            head = head.next;
            head.last = null;
        }

        if (k < 0) {

            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }

}
