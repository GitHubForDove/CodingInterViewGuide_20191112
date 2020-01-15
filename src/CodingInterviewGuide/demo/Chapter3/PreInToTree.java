package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.HashMap;

/**
 * 题目：
 *  已知一颗二叉树的所有节点值都不同，给定这颗二叉树正确的先序、中序和后序数组。
 *  请跟别为三个函数 实现任意两种数组结合重建原来的二叉树，并返回重构二叉树的头节点.
 */
public class PreInToTree {

    /**
     * 根据先序和中序 重建二叉树
     */
    public TreeNode  preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }


    private TreeNode preIn(int[] pre, int pi, int pj, int[] n, int ni,
                           int nj, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }

        TreeNode head = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        head.left = preIn(pre, pi+1, pi+index -ni, n, ni, index-1, map);
        head.right = preIn(pre, pi + index - ni + 1, pj, n, index+1, nj, map);

        return head;
    }


}
