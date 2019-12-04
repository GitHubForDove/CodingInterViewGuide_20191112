package CodingInterviewGuide.demo.Chapter2;


/**
 * 计算数组的小和
 *
 * 题目：
 *   例如，数组 s=[1,3,5,2,4,6],再s[0]的左边小于或者等于 s[0]的数的和为0，在s[1]的左边小于或等于s[1]的数的和为1，
 *   在s[2]的左边小于或等于s[2]的数的和为 1+3=4， 在s[3]的左边小于或等于 s[3]的数的和为1， 在 s[4] 的左边小于或等于
 *   s[4]的数的和为 1+3+2=6, 在 s[5]的左边小于或等于 s[5]的数的和为 1+3+5+2+4=15,所以s的小和为 0+1+4+1+6+15=27。
 *
 *   给定一个数组，实现函数返回s的小和
 */
public class GetSmallSum {

    public int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return func(arr, 0, arr.length-1);
    }

    private int func(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        return func(arr, left, mid) + func(arr,mid+1, right) + merge(arr, left, mid, right);
    }

    /**
     * 合并
     */
    public int merge(int[] s, int left, int mid, int right) {
        int[] h = new int[right - left + 1];
        int hi = 0;
        int i = left;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <= right) {
            if (s[i] <= s[j]) {
                smallSum += s[i] * (right - j + 1);
                h[hi++] = s[i++];
            } else {
                h[hi++] = s[j++];
            }
        }
        for (; (j < right + 1) || (i < mid + 1); j++,i++) {
            h[hi++] = i > mid ? s[j] : s[i];
        }
        for (int k=0; k != h.length; k++) {
            s[left++] = h[k];
        }

        return smallSum;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4,6};
        GetSmallSum gs = new GetSmallSum();
        int res = gs.getSmallSum(arr);
        System.out.println(res);
    }

}
