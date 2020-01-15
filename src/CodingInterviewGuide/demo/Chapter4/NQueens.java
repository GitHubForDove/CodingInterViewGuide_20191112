package CodingInterviewGuide.demo.Chapter4;

/**
 * N皇后问题
 * <p>
 * 题目：
 * N 皇后问题是指在 NxM的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，也不在同一条斜线上。
 * 给定一个整数n，返回n皇后的摆法有多少种。
 */
public class NQueens {

    public int num1(int n) {
        if (n < 1) {
            return 1;
        }
        // record[i] 表示 皇后在第i行皇后所在的列数。
        int[] record = new int[n];
        return process1(0, record, n);
    }

    private int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            // j == record[k] 判断是否存在 皇后在一列上
            // Math.abs(record[k] - j) == Math.abs(i - k) 判断是否有皇后在同一条斜线上
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

}
