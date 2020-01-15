package CodingInterviewGuide.demo.Chapter8;

public class GetSmallSum {

    /**
     * 使用归并  每次求 两个数组的最小和 最后累加 就是最后的最小和
     */
    public int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return func(arr, 0, arr.length - 1);
    }

    private int func(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        return func(arr, l, mid) + func(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] h = new int[r - l + 1];
        int hi = 0;
        int i = l;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                // 求累加和
                smallSum += arr[i] * (r - j + 1);
                h[hi++] = arr[i++];
            } else {
                h[hi++] = arr[j++];
            }
        }

        for (; (j < r + 1) || (i < mid + 1); j++, i++) {
            h[hi++] = i > mid ? arr[j] : arr[i];
        }
        for (int k = 0; k != h.length; k++) {
            arr[l++] = h[k++];
        }

        return smallSum;
    }
}
