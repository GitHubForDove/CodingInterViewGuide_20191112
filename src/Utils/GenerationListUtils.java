package Utils;

/**
 * 生成 链表
 */
public class GenerationListUtils {

    public static ListNode generationList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i=0; i<nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head.next;
    }

}
