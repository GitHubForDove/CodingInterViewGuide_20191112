package Utils;

import java.util.Stack;

/**
 * 数打印工具类
 */
public class PrintTreeUtils {


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
     * 非递归的方式实现二叉树的前序遍历
     */
    public static void preOrdderUnRecur(TreeNode head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.empty()) {
                head = stack.pop();
                System.out.println(head.value + ",");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

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
     * 树的中序遍历  非递归版
     * @param head
     */
    public static void inOrderUnRecur(TreeNode head) {
        System.out.println("in-order");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || head != null) {

                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + ",");
                    head = head.right;
                }

            }
        }
        System.out.println();
    }



    /**
     * 树的后序遍历 打印
     */
    public static void lastPrintTree(TreeNode head) {
        if (head != null) {
            midPrintTree(head.left);
            midPrintTree(head.right);
            System.out.println(head.value);
        }
    }

    /**
     * 后序遍历 非递归版
     */
    public static void posOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + ",");
            }
        }
    }



    }
