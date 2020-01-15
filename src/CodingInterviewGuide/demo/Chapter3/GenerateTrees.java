package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 *      给定一个整数N，如果N<1，代表空数结构，否则代表中序遍历的结果 {1，2，3，...,N}。
 *      假设可能的二叉树有M种，请返回M个二叉树的头节点，每一棵二叉树代表一种可能的结构。
 */
public class GenerateTrees {

    public List<TreeNode> genrateTrees(int n) {
        return generate(1,n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
        }

        TreeNode head = null;
        for (int i=start; i<end+1; i++) {
            head = new TreeNode(i);
            List<TreeNode> lSubs = generate(start, i-1);
            List<TreeNode> rSubs = generate(i+1, end);
            for (TreeNode l : lSubs) {
                for (TreeNode r : rSubs) {
                    head.left = l;
                    head.right = r;
                    res.add(cloneTree(head));
                }
            }
        }
        return res;
    }

    private TreeNode cloneTree(TreeNode head) {
        if (head == null) {
            return null;
        }

        TreeNode res = new TreeNode(head.value);
        res.left = cloneTree(res.left);
        res.right = cloneTree(res.right);
        return res;
    }


}
