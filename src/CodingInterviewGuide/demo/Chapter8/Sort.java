package CodingInterviewGuide.demo.Chapter8;

import Utils.SwapUtils;

import java.util.Arrays;

/**
 * 给定一个数组arr，其中只可能包含0，1，2三个值，请实现arr的排序
 * 另外一种问法为：
 *  有一个数组，再给定一个值k，请实现比k小的数都放在数组的左边，
 *  等于k的数都放在数组的中间，比k大的数都放在数组的右边。
 */
public class Sort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right) {
            if (arr[index] == 0) {
                SwapUtils.swap(arr, ++left, index++);
            } else if (arr[index] == 2) {
                SwapUtils.swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,1,2,1,1,0,0,2,2};
        Sort sort = new Sort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
