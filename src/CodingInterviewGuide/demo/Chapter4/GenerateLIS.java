package CodingInterviewGuide.demo.Chapter4;


import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * 题目：
 *  给定数组 arr, 返回 arr 的最长递增子序列
 *
 *  举例：
 *    arr = [2,1,5,3,6,4,8,9,7],返回最长递增子序列为[1,3,4,8,9]
 *
 *  要求：
 *    如果 arr 长度为 N，请实现事件复杂度为 O(NlogN)的方法。
 */
public class GenerateLIS {

    public int[] getDp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * 将下层循环 变为二分查找 减少事件复杂度
     */
    public int[] getDp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            right = Math.max(right, l);
            ends[i] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    /**
     * 根据dp 数组反向生成 lis
     */
    public int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        // 找出最大数的下标 index
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] -1) {
                lis[--len] =  arr[i];
                index = i;
            }
        }

        return lis;
    }

    public int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getDp1(arr);
        return generateLIS(arr, dp);
    }

    public static void main(String[] args) {
        GenerateLIS g = new GenerateLIS();
        int[] arr = new int[]{2,1,5,3,6,4,8,9,7};
        int[] res = g.lis1(arr);
        System.out.println(Arrays.toString(res));
    }
}
