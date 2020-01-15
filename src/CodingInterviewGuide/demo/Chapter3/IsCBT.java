package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵二叉树是否是完全二叉树
 */
public class IsCBT {


    /**
     * 1 按层次遍历二叉树,从每层的左边向右边依次遍历所有的节点
     * 2 如果当前节点有右孩子,但没有左孩子,直接返回 false
     * 3 如果当前节点并不是左右孩子都有,那之后的节点必须都为叶节点,否则返回false
     * 4 遍历过程中如果不返回false,遍历结束后返回true
     */
    public boolean isCBT(TreeNode head) {

        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode l = null;
        TreeNode r = null;
        boolean leaf = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l!= null || r != null)) || (l == null && r != null)) {
                return false;
            }

            if (l != null) {
                queue.offer(l);
            }

            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
