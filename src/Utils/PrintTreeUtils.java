package Utils;

/**
 * 数打印工具类
 */
public class PrintTreeUtils {

    /**
     * 树的中序遍历 打印
     */
    public static void midPrintTree(TreeNode head) {
        if (head != null) {
            midPrintTree(head.left);
            System.out.println(head.value);
            midPrintTree(head.right);
        }
    }


    /**
     * 树的前序遍历 打印
     */
    public static void prePrintTree(TreeNode head) {
        if (head != null) {
            System.out.println(head.value);
            midPrintTree(head.left);
            midPrintTree(head.right);
        }
    }

    /**
     * 树的前序遍历 打印
     */
    public static void lastPrintTree(TreeNode head) {
        if (head != null) {
            midPrintTree(head.left);
            midPrintTree(head.right);
            System.out.println(head.value);
        }
    }
}
