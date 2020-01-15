package CodingInterviewGuide.demo.Chapter8;


/**
 * 子矩阵的最大累加和问题
 *
 * 题目：
 *    给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和。
 *
 *    例如：矩阵 matrix 为：
 *    -90 48 78
 *    64 -40 64
 *    -81 -7 66
 *    其中，最大累加和的子矩阵为：
 *    48  78
 *    -40 64
 *    -7  66
 *    所以返回累加和为209
 */
public class MaxSum_Matrix {


    /**
     * 将多行 变为一行来进行计算 实际也是对一行的处理
     */
    public int maxSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null; // 累加数组

        for (int i = 0 ; i != matrix.length; i++) {
            s = new int[matrix[0].length];
            for (int j=i; j != matrix.length; j++) {
                cur = 0;
                for (int k=0; k != s.length; k++) {
                    s[k] += matrix[j][k];
                    cur += s[k];
                    max = Math.max(cur, max);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-90,48,78},
                {64,-40,64},
                {-81,-7,66},
        };

        MaxSum_Matrix msm = new MaxSum_Matrix();
        int res = msm.maxSum(matrix);
        System.out.println(res);
    }
}
