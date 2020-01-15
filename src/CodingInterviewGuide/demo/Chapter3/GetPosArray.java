package CodingInterviewGuide.demo.Chapter3;


import java.util.HashMap;

/**
 * 通过先序和中序数组生成后序数组
 *
 * 题目：
 *  已知一颗二叉树的所有节点值都不同，给定这棵树正确的先序和中序数组，不要重建整棵树，
 *  而是通过这两个数组直接生成正确的后序数组。
 */
public class GetPosArray {

    public int[] getPosArray(int[] pre, int[] in) {
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<len ;i++) {
            map.put(in[i], i);
        }

        setPos(pre, 0, len-1, in, 0, len-1, pos, len-1, map);
        return pos;
    }

    private int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s,
                        int si, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return si;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        // 找si的位置
        si = setPos(p, pj - nj + i + 1, pj, n, i+1, nj, s, si, map);
        return setPos(p, pi+1, pi + i - ni, n, ni, i-1, s, si, map);
    }
}
