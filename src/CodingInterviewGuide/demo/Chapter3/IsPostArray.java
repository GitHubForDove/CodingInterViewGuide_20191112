package CodingInterviewGuide.demo.Chapter3;


/**
 * 根据后序数组重建搜索二叉树
 *
 * 题目:
 *  给定一个整型数组 arr, 已知其中没有重复值,判断arr 是否可能是节点值类型为整形的搜索二叉树后序遍历结果.
 *
 */
public class IsPostArray {

    public boolean isPosArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        return isPost(arr, 0, arr.length - 1);
    }

    private boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }

        int less = -1;
        int more = end;

        for (int i=start ; i<end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }

        // 如果 数组最后的值 大于所有的前面的值 那么 最后的值向前移动一个位置
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        // 如果不满足 划分 就不是搜索二叉树
        if (less != more-1) {
            return false;
        }

        return isPost(arr, start, less) && isPost(arr, more, end -1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,6,5,7,4};
        IsPostArray ipa = new IsPostArray();
        boolean res = ipa.isPosArray(arr);
        System.out.println(res);
    }

}
