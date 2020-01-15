package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 *
 * 题目:
 *  给定一棵树的头节点 head , 已知所有的值都不一样,返回其中最大的且符合搜索二叉树条件的最大拓扑结构的大小
 */
public class BSTTopoSize {

    public int bstTopoSize(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int max = maxTopo(head, head);
        max = Math.max(bstTopoSize(head.left), max);
        max = Math.max(bstTopoSize(head.right), max);

        return max;
    }

    private int maxTopo(TreeNode h, TreeNode n) {
        if (h != null && n != null && isBSTNode(h,n,n.value)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    private boolean isBSTNode(TreeNode h, TreeNode n, int value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }

        return isBSTNode(h.value > value ? h.left : h.right , n, value);
    }
}
