package CodingInterviewGuide.demo.Chapter2;


import Utils.PrintTreeUtils;
import Utils.TreeNode;

/**
 * 将有序数组转换成二叉搜索树
 *
 * leetcode 108 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return nums == null ? null : buildTree(nums, 0, nums.length-1);
    }

    // 分治 + 递归 构造树结构
    private TreeNode  buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r)>>1;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m-1);
        root.right = buildTree(nums, m+1, r);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST satb = new SortedArrayToBST();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode head = satb.sortedArrayToBST(nums);
        PrintTreeUtils.midPrintTree(head);
    }
}
