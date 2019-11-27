package CodingInterviewGuide.demo.Chapter2;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换为双向链表
 */
public class Convert {

    public TreeNode convert(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (cur != null) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    /**
     * 中序遍历 将节点添加到队列中
     */
    public void inOrderToQueue(TreeNode head, Queue<TreeNode> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.add(head);
        inOrderToQueue(head.right, queue);
    }
}
