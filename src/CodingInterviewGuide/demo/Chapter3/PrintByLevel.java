package CodingInterviewGuide.demo.Chapter3;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印与ZiaZag打印
 *
 * 题目:
 *      给定一棵树的头节点 head, 分别实现按层打印 和 ZigZag打印二叉树的函数
 *      例如:二叉树如图 所示:
 *             1
 *           /  \
 *          2     3
 *         / \   / \
 *              5   6
 *             / \
 *            7   8
 *
 *     按层打印:
 *             1
 *             2 3
 *             4 5 6
 *             7 8
 *     ZiaZig打印,输出格式必须如下:
 *         1
 *         3 2
 *         4 5 6
 *         8 7
 */
public class PrintByLevel {

    public void printByLevel(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        queue.offer(head);
        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }

            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel " + (level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.right.left.left = new TreeNode(7);
        head.right.left.right = new TreeNode(8);
        PrintByLevel pbl = new PrintByLevel();
        pbl.printByLevel(head);

    }

}
