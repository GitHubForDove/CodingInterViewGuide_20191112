package CodingInterviewGuide.demo.Chapter8;


import Utils.SwapUtils;

import java.util.Arrays;

/**
 * 数组的partition调整
 *
 * 题目：
 *  给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，而不用保证左部分是否有序。
 *  例如：arr=[1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9],调整之后arr=[1,2,3,4,5,6,7,8,9,...]
 */
public class LeftUnique {


    public void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i++] != arr[u]) {
                SwapUtils.swap(arr, ++u, i-1);
            }
        }
    }

    public static void main(String[] args) {
        LeftUnique leftUnique = new LeftUnique();
        int[] arr = new int[]{1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
        leftUnique.leftUnique(arr);
        System.out.println(Arrays.toString(arr));
    }

}
