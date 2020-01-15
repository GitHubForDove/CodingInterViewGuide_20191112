package CodingInterviewGuide.demo.Chapter8;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 最长可整合子数组的长度
 *  题目:
 *    先给出可整合数组的定义。如果一个数组在排序之后，每相邻两个数差的绝对值都为1，则该数组为可整合数组。
 *    例如：【5，3，4，6，2】，符合每相邻两个数差的绝对值为1，所以这个数组为可整合数组。
 *    给定一个数组 arr,请返回其最大可整合子数组的长度。例如：【5，5，3，2，6，4，3】的最大可整合子数组为
 *    【5，3，2，6，4】，所以返回5.
 */
public class GetLTL {

    public int getLTL(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (isIntegrated(arr, i, j)) {
                    len = Math.max(len, j-i+1);
                }
            }
        }

        return len;
    }

    private boolean isIntegrated(int[] arr, int i, int j) {
        int[] nums = Arrays.copyOfRange(arr, i, j+1);
        Arrays.sort(nums);
        for (int n=1; n<nums.length; n++) {
            if (nums[n]-nums[n-1] != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     *  方法二：
     *  思路：判断一个数组是否是可整合数组还可以用下面的方法来判断，一个数组中如果没有重复元素，并且这个如果最大值减去
     *  最小值，再加上1的结果等于元素个数(max-min+1 == 元素个数)，那么这个数组就是可整合数组。
     *  例如: [3,2,5,6,4], max = min + 1 = 6-2+1 = 5 == 元素个数， 所以为可整合数组。
     *
     */
    public int getLTL2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>(); // 用于判断重复元素
        for (int i=0; i<arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j=i; j<arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                // 新的检验方式
                if (max-min == j-i) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,5,3,2,6,4,3};
        GetLTL gltl = new GetLTL();
        int res = gltl.getLTL(arr);
        System.out.println(res);
    }
}
