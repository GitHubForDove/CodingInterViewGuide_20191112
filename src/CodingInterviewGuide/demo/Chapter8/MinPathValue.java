package CodingInterviewGuide.demo.Chapter8;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短通路路径
 *
 * 题目：
 *    用一个整形矩阵 matrix 表示一个网络，1代表有路，0表示无路，每一个位置只要不越界，都有上下左右
 *    四个方向，求从最左上角到最右下角的最短通路值。
 */
public class MinPathValue {

    public int minPathValue(int[][] m ) {
        if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1
                || m[m.length-1][m[0].length-1] != 1) {
            return 0;
        }

        int res = 0;
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();

            // 最短的最快到最后 所以不需要对这个方面考虑
            if (r == m.length-1 && c == m[0].length-1) {
                return map[r][c];
            }
            walkTo(map[r][c], r-1, c, m, map, rQ, cQ); // up
            walkTo(map[r][c], r+1, c, m, map, rQ, cQ); // down
            walkTo(map[r][c], r, c-1, m, map, rQ, cQ); // left
            walkTo(map[r][c], r, c+1, m, map, rQ, cQ); // right
        }
        return res;
    }

    public void walkTo(int pre, int toR, int toC, int[][] m, int[][] map,
                       Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
                || m[toR][toC] != 1 || map[toR][toC] != 0) {
            return;
        }

        map[toR][toC] = pre + 1;
        rQ.add(toR);
        cQ.add(toC);
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,1,1,1,1},
                {0,0,0,0,1}
        };
        MinPathValue mpv = new MinPathValue();
        int res = mpv.minPathValue(m);
        System.out.println(res);
    }
}
