package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 判断一棵树是否是搜索二叉树
 */
public class IsBanace {

    public boolean isBanace(TreeNode head) {
        if (head == null) {
            return true;
        }
        dfs(head);
        return res;
    }

    boolean res = true;
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (Math.abs(right-left+1) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }
}
