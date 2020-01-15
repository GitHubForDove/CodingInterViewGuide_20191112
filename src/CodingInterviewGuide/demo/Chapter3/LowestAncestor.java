package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * 题目：
 *  给定一棵树的头节点head，以及这棵树中的两个节点 o1 和 o2，请返回 o1和 o2的最近公共祖先节点。
 */
public class LowestAncestor {

    public TreeNode lowestAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }

        TreeNode left = lowestAncestor(head.left, o1, o2);
        TreeNode right = lowestAncestor(head.right, o1, o2);

        if (left != null && right != null) {
            return head;
        }

        return left != null ? left : right;
    }
}
