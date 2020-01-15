package CodingInterviewGuide.demo.Chapter8;


import java.util.Arrays;

/**
 * 不包含位置值的累乘数组
 *
 * 题目：
 *  给定一个数组 arr, 返回不包括本位置的累乘数组。
 *  例如：arr=[2,3,1,4],返回【12，8，24，6】,即除自己外，其他位置上的累乘。
 */
public class Product {

    public int[] product(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int count = 0;
        int all = 1;
        int[] res = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                all *= arr[i];
            } else {
                count++;
            }
        }

        if (count == 0) {
            for (int i=0; i<arr.length; i++) {
                res[i] = all / arr[i];
            }
        } else if (count == 1){
            for (int i=0; i<arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = all;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1,0,7};
        Product p = new Product();
        int[] res = p.product(arr);
        System.out.println(Arrays.toString(res));
    }
}
