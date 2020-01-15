package CodingInterviewGuide.demo.Chapter4;


/**
 * 跳跃游戏
 *
 * 题目：
 *  给定数组 arr, arr[i]==k 代表可以从位置 i 向右 跳 1~k 个距离。
 *  比如，arr[2] == 3,代表从位置2可以跳到位置3、位置4或位置5.如果 从位置0出发，返回最少几次能跳到 arr最后的位置上。
 *
 *  举例：
 *   arr=[3,2,3,1,1,4]
 *
 *   arr = 3, 选择跳到位置2； arr[2] == 3,可以跳到最后的位置。所以返回2.
 */
public class Jump {

    public int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int jump = 0;
        int next = 0;
        int cur = 0;
        /**
            1 如果 cur >= i, 说明jump步可以到达位置 ，此时什么都不做
            2 如果 cur < i, 说明只跳 jump+1步能够到达的位置，即next。
            3 将next 更新成 math.max(next, i + arr[i]), 表示下一次多跳一步到达的最远位置。
         */
        for (int i=0; i<arr.length; i++) {
            if (cur < i) {
                jump ++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }
}
