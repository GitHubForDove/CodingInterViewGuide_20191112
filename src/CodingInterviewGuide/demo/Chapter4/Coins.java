package CodingInterviewGuide.demo.Chapter4;


/**
 * 换钱的方法
 *
 * 题目：
 *  给定数组 arr, arr中所有的值都为正数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 *  再给定一个整数 aim 代表要找的钱数，求换钱有多少种方法。
 */
public class Coins {

    /**
     * 暴力递归  时间复杂度比较高
     */
    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return process1(arr, 0, aim);
    }

    private int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {

            for (int i=0; arr[index] * i <= aim; i++) {
                res  += process1(arr, index+1, aim-arr[index] * i);
            }
        }

        return res;
    }

    /**
     * 优化暴力递归  初步优化
     */
    public int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length+1][aim+1];
        return process2(arr, 0, aim, map);
    }

    /**
     * map[i][j] == 0 表示递归过程 p(i,j)从来没有计算过
     * map[i][j] == -1 表示递归过程p(i,j) 计算过，但返回值为 0. 如果map[i][j]的值既不等于 0 ，也不等于 -1 ， 记为 a，
     * 则表示递归过程 p(i,j)的返回值为 a。
     */
    private int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i=0; arr[index] * i <= aim; i++) {
                //   index+1 为下一个过程的返回值
                mapValue = map[index+1][aim-arr[index]*i];

                // 优化 减少重复计算
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res  += process2(arr, index+1, aim-arr[index] * i, map);
                }

            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    /**
     * dp 动态规划
     */
    public int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][aim+1];
        // dp第一列的值 dp[...][0]，表示组成钱数为0的方法数，很明显只有1种，也就是不使用任何货币。
        // 所以dp第一列的值统一设置为1
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }

        // 对于矩阵dp第一行的值dp[0][...]，表示只能使用arr[0]这一种货币的情况下，组成钱的方法数。
        // 比如， arr[0] == 5 时，能组成的钱数只有 0，5，10，15，...，所以
        // 令dp[0][k*arr[0]]=1
        for (int j=1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }

        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k=0; j - arr[i] * k  >= 0; k++) {
                    // 完全不用 arr[i]货币，只使用arr[0...i-1]货币时，方法数为dp[i-1][j]
                    // 用1张 arr[i]货币，剩下的钱用arr[0...i-1]货币组成，方法数位dp[i-1][j-arr[i]]
                    // 用2张 arr[i]货币，剩下的钱用arr[0...i-1]货币组成，方法数位dp[i-1][j-2*arr[i]]
                    // 用3张 arr[i]货币，剩下的钱用arr[0...i-1]货币组成，方法数位dp[i-1][j-3*arr[i]]
                    // ...
                    // 用k张 arr[i]货币，剩下的钱用arr[0...i-1]货币组成，方法数位dp[i-1][j-k*arr[i]]
                    num += dp[i-1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length-1][aim];
    }

    public int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[] dp = new int[aim + 1];
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[arr[0] * j] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }

        return dp[aim];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        Coins c = new Coins();
        int res = c.coins2(coins, 5);
        System.out.println(res);
    }
}
