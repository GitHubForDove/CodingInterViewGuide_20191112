package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 打印二叉树的边界节点
 *
 * 题目:
 *  给定一棵二叉树的头节点head,按照如下两种标准分别实现二叉树边界节点的逆时针打印:
 *
 *  标准一:
 *  1. 头节点为边界节点
 *  2. 叶节点为边界节点
 *  3 如果节点在其所在的层中是最左或 最右的,那么也是边界节点
 */
public class PrintEdge {

    public void printEdge(TreeNode head) {
        if (head == null) {
            return;
        }

        int height = getHeight(head, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边界
        for (int i=0; i != edgeMap.length; i++) {
            System.out.println(edgeMap[i][0].value + " ");
        }

        // 打印既不是左边界,也不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);
        for (int i = edgeMap.length-1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.println(edgeMap[i][1].value + " ");
            }
        }
    }

    private void printLeafNotInMap(TreeNode head, int i, TreeNode[][] edgeMap) {

    }

    private void setEdgeMap(TreeNode head, int i, TreeNode[][] edgeMap) {
        if (head == null) {
            return;
        }

        edgeMap[i][0] = edgeMap[i][0] == null ? head : edgeMap[i][0];
        edgeMap[i][1] = head;
        setEdgeMap(head.left, i+1, edgeMap);
        setEdgeMap(head.right, i+1, edgeMap);
    }

    private int getHeight(TreeNode head, int n) {
        if (head == null) {
            return n;
        }

        return Math.max(getHeight(head.left, n+1), getHeight(head.right, n+1));
    }




}
