package CodingInterviewGuide.demo.Chapter8;


import java.util.*;

/**
 * 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 * <p>
 * 题目：
 * 给定排序数组 arr 和整数 k，不重复打印 arr中相加和为 k 不降序的二元组。
 * 例如： arr= [-8,-4,-3,0,1,2,4,5,8,9], k =10，打印结果为：
 * 1，9
 * 2，8
 */
public class PrintUniquePair {

    /**
     * 暴力 解法
     */
    public List<List<Integer>> printUniquePair(int[] arr, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k && !set.contains(arr[i])) {
                    list.add(arr[i]);
                    list.add(arr[j]);
                    res.add(new ArrayList<>(list));
                    list.clear();
                    set.add(arr[i]);
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     */
    public List<List<Integer>> printUniquePair2(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        HashSet<Integer> set = new HashSet<>();

        while (left < right) {
            if (arr[left] + arr[right] == k) {
                if (!set.contains(arr[left])) {
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(new ArrayList<>(list));
                    list.clear();
                }
                set.add(arr[left]);
                left++;
                right--;
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-8, -4, -3, 0, 1, 1, 2, 4, 5, 8, 9, 9};
        PrintUniquePair pup = new PrintUniquePair();
        List<List<Integer>> res = pup.printUniquePair2(arr, 10);
        for (List<Integer> x : res) {
            System.out.println(x);
        }
    }
}
