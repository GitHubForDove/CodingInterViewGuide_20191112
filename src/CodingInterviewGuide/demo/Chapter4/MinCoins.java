package CodingInterviewGuide.demo.Chapter4;


import java.util.Arrays;

/**
 * 零钱兑换
 */
public class MinCoins {

    /**
     * 暴力递归  超时
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }

            int subProb = coinChange(coins, amount - coin);

            if (subProb == -1) {
                continue;
            }
            ans = Math.min(ans, subProb + 1);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 暴力递归  加备忘录 子问题 记录下来
     */
    public int coinChange2(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, -2);
        return helper(coins, amount, arr);
    }

    private int helper(int[] coins, int amount, int[] arr) {
        if (amount == 0) {
            return 0;
        }

        if (arr[amount] != -2) {
            return arr[amount];
        }

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }

            int subProb = helper(coins, amount - coin, arr);

            if (subProb == -1) {
                continue;
            }
            ans = Math.min(ans, subProb + 1);
        }
        // 记录 子问题的最优题解
        arr[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return arr[amount];
    }

    /**
     * 动态规划 dp数组
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin < i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * dfs 深搜  剪枝  更快
     */
    public int coinChange4(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        dfs(coins, amount, 0, coins.length - 1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int res = Integer.MAX_VALUE;

    private void dfs(int[] coins, int amount, int count, int index) {

        if (index < 0 || count + amount / coins[index] >= res) return;
        if (amount % coins[index] == 0) {
            res = Math.min(res, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            dfs(coins, amount - i * coins[index], count + i, index - 1);
        }
    }


    /**
     * 动态规划 二维数组
     */
    public int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    dp[i][j] = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    /**
     * 基于上面解法的优化
     */
    public int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }
}
