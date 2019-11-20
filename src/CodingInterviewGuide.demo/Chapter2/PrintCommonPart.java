package CodingInterviewGuide.demo.Chapter2;

/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommonPart {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void printCommonPart(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return;
        }

        while (head1 != null && head2 != null) {

            if (head1.val == head2.val) {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }else if (head1.val < head2.val) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
