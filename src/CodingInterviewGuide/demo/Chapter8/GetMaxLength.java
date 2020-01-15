package CodingInterviewGuide.demo.Chapter8;

/**
 * 未排序正数数组中累加和为给定值的最长子数组长度
 *
 * 题目：
 *    给定一个数组 arr, 该数组无序，但每个值均为正数，再给定一个正数k。求arr的所有子数组中所有元素相加
 *    和为k的最长子数组长度。
 *
 *    例如： arr=[1,2,1,1,1], k=3
 *    累加和为 3 的最长子数组为[1,1,1]，所以结果返回 3。
 */
public class GetMaxLength {

    public int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLength = 0;
        while (left <= right && right < arr.length) {
            if (sum == k) {
                maxLength = Math.max(maxLength, right-left+1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left--];
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,1,1};
        GetMaxLength gm = new GetMaxLength();
        int res = gm.getMaxLength(arr, 3);
        System.out.println(res);
    }
}
