package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 通过有序数组生成 平衡二叉树
 * 题目:
 *  给定一个有序数组 sortArr,已知其中没有重复值,用这个有序数组生成一颗平衡搜索二叉树
 *  并该搜索二叉树中序遍历的结果和 arr 一致.
 */
public class GenerateTree {

    public TreeNode generateTree(int[] nums) {
        return nums != null ? generate(nums, 0, nums.length-1) : null;
    }

    private TreeNode generate(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generate(nums, start, mid -1);
        root.right = generate(nums, mid + 1, end);
        return root;
    }
}
