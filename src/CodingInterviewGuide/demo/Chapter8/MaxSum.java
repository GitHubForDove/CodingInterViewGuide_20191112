package CodingInterviewGuide.demo.Chapter8;


/**
 * 子数组的最大累加和问题
 * <p>
 * 题目：
 * 给定一个数组 arr，返回子数组的最大累加和。
 * 例如：arr = [1,-2,3,5,-2,6,-1],所有子数组中，[3,5,-2,6]可以累加出最大的和12，
 * 所以返回12
 */
public class MaxSum {

    /**
     * 思路1：
     *     当sum累加 小于0时 直接丢弃前面的累加  将sum 赋值 0 ，再冲下个下标开始累加 并比较最大的和。
     * @param arr
     * @return
     */
    public int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    /**
     * 思路2 ：
     *  使用dp的思想 解决问题
     *
     *  从底向上的思想
     */
    public int maxSum2(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (maxNum < dp[i]) {
                maxNum = dp[i];
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 5, -2, 6, -1};
        MaxSum ms = new MaxSum();
        int res = ms.maxSum(nums);
        System.out.println(res);
    }
}
