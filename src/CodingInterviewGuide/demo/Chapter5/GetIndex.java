package CodingInterviewGuide.demo.Chapter5;


/**
 * 在有序但含有空的数组中查找字符串
 *
 *  题目：
 *      给定一个字符串数组strs[],在strs中有些位置未null，但在不为null的位置上，其字符串是按照字典顺序
 *    由小到大依次出现的。再给定一个字符串str，请返回str在strs中出现的最左的位置。
 *
 *   例如：
 *   strs=[null,"a",null,"a",null,"b",null,"c"],str="a",返回-1。
 */
public class GetIndex {

    /**
     * 思路：
     *    使用二分查找 来进行比较。
     *    
     *
     */
    public int getIndex(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }

        int res = -1;
        int left = 0;
        int right = strs.length-1;
        int mid = 0;
        int i=0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    left = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && --i >= left);

                // 如果左边都为空 或者 字符比str要小  left = mid + 1
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    // 左边继续比较  将res 进行对比
                    res = strs[i].equals(str) ? i : res;
                    right = i-1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{null,"a",null,"a",null,"b",null,"c"};
        GetIndex gi = new GetIndex();
        int index = gi.getIndex(strs, "a");
        System.out.println(index);
    }

}
