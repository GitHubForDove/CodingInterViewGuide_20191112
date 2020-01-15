package CodingInterviewGuide.demo.Chapter8;


/**
 * 在数组中 找到一个局部最小的位置
 *
 * 题目：
 *    定义局部最小的概念。 arr 长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1],那么 arr[0]局部最小；如果
 *    arr[N-1] < arr[N-2]，那么 arr[N-1]是局部最小；
 *    如果0 <i < N-1，既有arr[i]<arr[i-1]，又有arr[i]<arr[i+1]，那么 arr[i]是局部最小。
 *
 *    给定一个无序数组 arr,已知 arr 中任意两个相邻的数都不相等。写一个函数，只需返回 arr 中任意一个局部最小出现的位置即可。
 */
public class GetLessIndex {

    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // 不存在
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length-1] < arr[arr.length-2]) {
            return arr.length-1;
        }

        int left = 1;
        int right = arr.length-2;

        int mid = 0;
        while (left < right) {
            mid = (right + left) >> 1;

            if (arr[mid] > arr[mid-1]) {// 如果中间的数 比中间前面一个数大  说明 左边一定有局部最小值
                right = mid -1;
            } else if (arr[mid] > arr[mid+1]) { // 如果比后面的一个数大  说明 右边一定有局部最小值
                left = mid+1;
            } else {
                return mid; // 中间的数比两边都小 肯定是局部最小值了
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
