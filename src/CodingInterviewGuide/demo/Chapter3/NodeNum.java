package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

/**
 * 统计完全二叉树的节点数
 *
 * 题目：
 *  给定一颗二叉树的头节点head，返回这棵树的节点个数
 */
public class NodeNum {




    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    private int bs(TreeNode node, int l, int h) {
        if (l == h) {
            return 1;
        }
        // 如果 节点的右边可以到最后一层
        if (mostLeftLevel(node.right, l+1) == h) {
            return (1 << (h-l)) + bs(node.right, l+1, h);
        } else {
            return (1 << (h-l-1)) + bs(node.left, l+1, h);
        }
    }

    /**
     *  求最大 level
     */
    private int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level ++;
            node = node.left;
        }
        return level-1;
    }


    public int nodeNum2(TreeNode head) {
        if(head == null) return 0;
        return nodeNum2(head.left) + nodeNum2(head.right) + 1;
    }


    public static void main(String[] args) {

    }
}
