package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.HashMap;

/**
 * 给出 中序和后序 重建二叉树
 */
public class InPosToTree {

    /**
     * 跟 先序和中序 重建二叉树 差不多的思路, 不过 中序和后序  是根据后序的最右边的数 来进行划分左右子树.
     * @param in
     * @param pos
     * @return
     */
    public TreeNode inPosToTree(int[] in, int[] pos) {
        if (in == null || pos == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<in.length; i++) {
            map.put(in[i], i);
        }
        return inPos(in, 0, in.length-1, pos, 0, pos.length-1, map);
    }

    private TreeNode inPos(int[] in, int ni, int nj, int[] pos,
                           int si, int sj, HashMap<Integer, Integer> map) {
        if (si > sj) {
            return null;
        }

        TreeNode head = new TreeNode(pos[sj]);
        int index = map.get(pos[sj]);

        head.left = inPos(in, ni, index-1, pos, si, si+index-ni-1, map);
        head.right = inPos(in, index + 1, nj, pos, si + index -ni, sj-1, map);
        return head;
    }
}
