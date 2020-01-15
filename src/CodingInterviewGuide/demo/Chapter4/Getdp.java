package CodingInterviewGuide.demo.Chapter4;


/**
 * 最长递增 子序列
 *
 * 题目：
 *  给定数组 arr, 返回 arr的最长递增子序列
 *
 *  举例：
 *
 *  arr = [2,1,5,3,6,4,8,9,7],返回最长递增子序列为 [1，3，4，8，9]
 */
public class Getdp {

    public int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[i] > dp[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp;
    }
}
