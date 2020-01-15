package CodingInterviewGuide.demo.Chapter8;

/**
 * 将一个矩阵顺时针转动 90度
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int col = matrix.length-1;
        int row = matrix[0].length-1;

        // 转置
        for (int i=0;i<=col; i++) {
            for (int j=i+1; j<=row; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 矩阵翻转
        for (int j=0; j <= col/2; j++) {
            for (int i=0; i<= row; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col-j];
                matrix[i][col-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };

        Rotate r = new Rotate();
        r.rotate(matrix);
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
