package CodingInterviewGuide.demo.Chapter2;


import Utils.GenerationListUtils;
import Utils.ListNode;

/**
 * 删除链表的a/b处的结点
 *
 * 例如：
 *  链表：1->2->3->4->5,将设a/b的值为r
 *  如果r等于0，不删除任何结点
 *  如果r在区间(0，1/5]，删除节点1
 *  如果r在区间（1/5,2/5],删除结点2
 *  如果r在区间（2/5,3/5],删除结点3
 *  如果r在区间（3/5,4/5],删除结点4
 *  如果r在区间（4/5,1],删除结点5
 *  如果r大于1，不删除任何结点
 *
 */
public class RemoveByRatio {


    /**
     * 思路：
     *  首先要解决的问题，如果根据链表的长度n，以及a与b的值决定该删除的结点是哪一个结点呢？
     *  根据如下方法：
     *      先计算double r = ((double)(a*n) / (double) b)的值，然后r向上取整之后的整数代表该删除的结点是第几个结点。
     *
     */
    public static ListNode removeByRatio(ListNode head, int a, int b) {
        if (a <1 || a > b) {
            return head;
        }

        int n=0;
        ListNode cur = head;
        while (cur!=null) {
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil((double) (a*n) / (double)b);

        if (n == 1) {
            return head.next;
        }

        if (n > 1) {
            cur = head;
            while (--n > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        ListNode head = GenerationListUtils.generationList(nums);
        ListNode res = removeByRatio(head, 1,2);
        while( res != null) {
            System.out.println(res.val + ",");
            res = res.next;
        }
    }
}
