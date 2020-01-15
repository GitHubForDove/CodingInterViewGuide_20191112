package CodingInterviewGuide.demo.Chapter8;


import java.util.Arrays;

/**
 * 奇数下标都是奇数或者 偶数下标都是偶数
 *
 * 题目：
 *    给定一个长度不小于2的数组 arr ,实现一个函数调整arr，那么让所有的偶数下标都是偶数，
 *    要么让所有的奇数下标都是奇数。
 *
 * 要求：
 *   如果 arr 的长度为 N ，函数要求时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 */
public class Modify {

    public void modify(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int even = 0;
        int odd = 1;
        int len = arr.length-1;
        while (even <= len && odd <= len) {
            if ((arr[len] & 1)  == 0) {
                swap(arr, even, len);
                even += 2;
            } else {
                swap(arr, odd, len);
                odd += 2;
            }
        }
    }

    public void swap(int[] arr, int index1, int index2) {
        if (index1 >= arr.length || index2 >= arr.length) {
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,3,2,4,6,5};
        Modify m = new Modify();
        m.modify(arr);
        System.out.println(Arrays.toString(arr));
    }
}
