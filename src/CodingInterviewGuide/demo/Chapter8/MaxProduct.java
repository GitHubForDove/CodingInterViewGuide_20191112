package CodingInterviewGuide.demo.Chapter8;


/**
 * 乘积最大子数组
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {

    /**
     *
     */
    public double maxProduc(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        double max = arr[0];
        double min = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        double res = arr[0];
        for (int i= 1; i<arr.length; i++) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    /**
     * 解决思路二 ：
     *     动态规划
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        double[] nums = new double[]{-2.5, 4, 0, 3, 0.5, 8, -1};
        MaxProduct mp = new MaxProduct();
        double res = mp.maxProduc(nums);
        System.out.println(res);
    }
}
