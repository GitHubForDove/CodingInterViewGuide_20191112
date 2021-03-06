package CodingInterviewGuide.demo.Chapter4;


/**
 * 龙与地下城游戏问题
 *
 * 题目：
 *  给定一个二维数组 map,含义是一张地图，例如，如下矩阵：
 *      -2 -3   3
 *      -5 -10  1
 *      0  30  -5
 *
 *  游戏的规则如下：
 *  * 骑士从左上角出发，每次只能向右或向下走，最后到达右下角见到公主。
 *  * 地图上每个位置的值代表骑士要遭遇的事情。如果是负数，说明此处有怪兽，要上骑士损失血量。如果是非负数，代表次数有血瓶，
 *  能让骑士回血。
 *  * 骑士从左下角到右下角的过程中，走到任何一个位置时，血量都不少于1.
 *
 *  为了保证骑士能见到公主，初始血量至少是多少？根据map，返回初始血量。
 */
public class MinHP {
    public int minHP(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 1;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = m[row][col] > 0 ? 1 : -m[row][col] + 1;

        // 初始化
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
        }

        // 初始化
        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(dp[row][j + 1] - m[row][j], 1);
        }

        int right = 0;
        int down = 0;
        for (int i = row - 1; i >= 0; i--) {
            //dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
            for (int j = col - 1; j >= 0; j--) {
                right = Math.max(dp[i][j + 1] - m[i][j], 1);
                down = Math.max(dp[i + 1][j] - m[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {0, 30, -5},
        };

        MinHP mhp = new MinHP();
        int res = mhp.minHP(m);
        System.out.println(res);
    }
}
