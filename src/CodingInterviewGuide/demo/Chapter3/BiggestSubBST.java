package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 找到二叉树中的最大搜索二叉树
 *
 * 题目：
 *  给定一颗二叉树的头节点 head, 已知其中所有节点的值都不一样，找到含有节点最多的搜索二叉树，
 * 并返回这颗二叉树的头节点.
 *
 */
public class BiggestSubBST {

    public TreeNode biggestSubBST(TreeNode head) {
        int[] record = new int[3];
        return posOrder(head, record);
    }

    private TreeNode posOrder(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
        }

        int value = head.value;
        TreeNode left = head.left;
        TreeNode right = head.right;

        TreeNode lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        TreeNode rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(lMax, value);
        if (left == lBST && right == rBST && lMax < value && value < rMin) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }


    public static void main(String[] args) {

    }
}
