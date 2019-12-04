package CodingInterviewGuide.demo.Chapter2;


import java.util.HashMap;

/**
 * 给定一个无数数组arr,其中元素可正、可负、可0.求arr所有子数组中正数与负数个数相等的最长子数组长度
 */
public class MaxLength_I {

    public static int getMaxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        for (int i=0; i< arr.length;i++) {
            if (arr[i] < 0) {
                arr[i] = -1;
            } else if (arr[i] > 0) {
                arr[i] = 1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int len = 0;

        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                len = Math.max(i-map.get(sum), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,1,0,-1,1,0,1,0,-1,-1};
        int res = getMaxLength(arr);
        System.out.println(res);
    }
}
