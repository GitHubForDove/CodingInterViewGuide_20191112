package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 判断一棵树是否是搜索二叉树.
 */
public class IsBST {

    public boolean isBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        midOrder(root);
        return res;
    }

    boolean res = true;
    double pre = -Double.MAX_VALUE;
    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        if (pre != Integer.MIN_VALUE && pre >= node.value) {
            res = false;
            return;
        }
        pre = node.value;
        midOrder(node.right);
    }

    public boolean isBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean res = true;
        TreeNode pre = null;
        TreeNode cur1 = root;
        TreeNode cur2 = null;

        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value >= cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

        public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        IsBST ib = new IsBST();
        boolean r = ib.isBST2(root);
        System.out.println(r);
    }
}
