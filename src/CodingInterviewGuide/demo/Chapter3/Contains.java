package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 判断 t1树是否包含 t2 树的全部拓扑结构
 */
public class Contains {

    /**
     *
     */
    public boolean contains(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) && contains(t1.left, t2) || contains(t1.right, t2);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if ((t1 == null && t2 != null) || (t1 != null && t2 == null) || t1.value != t2.value) {
            return false;
        }

        return check(t1.right, t2.right) && check(t1.left, t2.left);
    }
}
