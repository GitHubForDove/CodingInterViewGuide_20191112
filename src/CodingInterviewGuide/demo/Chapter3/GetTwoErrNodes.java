package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.Stack;

/**
 * 调整搜索二叉树中两个错误的节点
 * 题目:
 *  一棵二叉树原本是搜索二叉树,但是其中有两个节点调换了位置,使得这颗二叉树不再是搜索二叉树,
 *  请找出这两个错误的节点并返回.
 */
public class GetTwoErrNodes {

    public TreeNode[] getTwoErrNodes(TreeNode head) {
        TreeNode[] nodes = new TreeNode[2];
        if (head == null) {
            return nodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    nodes[0] = nodes[0] == null ? pre : nodes[0];
                    nodes[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return nodes;
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = getTwoErrNodes(root);
        if (nodes == null) {
            return;
        } else {
            int temp = nodes[0].value;
            nodes[0].value = nodes[1].value;
            nodes[1].value = temp;
        }
    }
}
