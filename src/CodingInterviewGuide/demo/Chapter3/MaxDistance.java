package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 二叉树节点间的最大距离
 *
 * 题目:
 *  从二叉树的节点A出发, 可以向上或者向下走,但沿途的节点只能经过一次,当到达节点B时,路径上的节点数叫作A到B的距离。
 */
public class MaxDistance {

    public int maxDistance(TreeNode head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }

    /**
     * 后序遍历
     */
    public int posOrder(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }

        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        // 返回的是 每个节点的最大距离
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }
}
