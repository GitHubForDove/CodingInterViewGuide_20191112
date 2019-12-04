package CodingInterviewGuide.demo.Chapter2;


import java.util.Arrays;

/**
 * 自然数的排序
 *
 * 题目：
 *    给定一个长度为N的整形数组 arr, 其中有N个互相不相等的自然数 1~N，
 *    请实现 arr 的排序，但是不要把下标0~N-1位置上的数通过直接赋值的方式替换成1~N。
 */
public class Sort {


    public static void sort(int[] arr) {
        int temp = 0;
        int next = 0;
        for (int i=0; i<arr.length; i++) {
            temp = arr[i];
            while (arr[i] != i+1) {
                next = arr[temp-1];
                arr[temp-1] = temp;
                temp = next;
            }
        }
    }


    public static void sort2(int[] arr) {
        int temp = 0;
        for (int i=0; i<arr.length; i++) {
            while (arr[i] != i+1) {
                temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,3,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
