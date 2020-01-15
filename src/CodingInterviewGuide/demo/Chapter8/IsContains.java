package CodingInterviewGuide.demo.Chapter8;

/**
 * 在行列都排好序的矩阵中 找数
 *
 *   题目：
 *      给定一个 NxM的整型矩阵 matrix 和一个整数 k，matrix的每一行和每一列都是排好序的。
 *      实现一个函数，判断k是否在matrix中。
 *      例如：
 *      0 1 2 5
 *      2 3 4 7
 *      4 4 4 8
 *      5 7 7 9
 *     如果k为7，返回true；如果k为6，返回false
 */
public class IsContains {

    public boolean isContains(int[][] matrix, int k) {
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == k) {
                return true;
            } else if (matrix[row][col] < k) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,5},
                {2,3,4,7},
                {4,4,4,8},
                {5,7,7,9},
        };

        IsContains ic = new IsContains();
        boolean res = ic.isContains(matrix, 7);
        System.out.println(res);
    }
}
