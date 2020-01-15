package CodingInterviewGuide.demo.Chapter8;

/**
 * 需要排序的最短子数组长度
 *
 * 题目：
 *    给定一个无序数组 arr,求出需要排序的最短子数组长度
 *    例如： arr = [1,5,3,4,2,6,7] 返回4， 因为只有 [5,3,4,2]需要排序。
 */
public class GetMinLength {

    public int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int min = arr[arr.length -1];
        int noMinIndex = -1;
        for (int i=arr.length-2; i >= 0 ; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(arr[i], min);
            }
        }

        if (noMinIndex == -1) {
            return 0;
        }

        int max = arr[0];
        int noMaxIndex = -1;
        for (int j=1; j<=arr.length-1; j++) {
            if (arr[j] < max) {
                noMaxIndex = j;
            } else {
                max = Math.max(max, arr[j]);
            }
        }

        return noMaxIndex - noMinIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1};
        GetMinLength gml = new GetMinLength();
        int res = gml.getMinLength(arr);
        System.out.println(res);
    }
}
