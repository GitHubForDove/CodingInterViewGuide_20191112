package CodingInterviewGuide.demo.Chapter8;


/**
 * 转圈打印矩阵
 * 给定一个整数矩阵 matrix，请按照转圈的方式打印它。
 */
public class SpiralOrderPrint {

    public void spiralOrderPrint(int[][] maxtrix) {
        int tR = 0;
        int tC = 0;
        int dR = maxtrix.length-1;
        int dC = maxtrix[0].length -1;
        while (tR <= dR && tC <= dC) {
            prinfEdge(maxtrix, tR++, tC++, dR--, dC--);
        }
    }

    private void prinfEdge(int[][] maxtrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i=0; i<= dC; i++) {
                System.out.print(maxtrix[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i=0; i<= tC; i++) {
                System.out.print(maxtrix[i][tC] + " ");
            }
        } else {
            int curR = tR;
            int curC = tC;

            while (curC != dC) {
                System.out.print(maxtrix[curR][curC++] + " ");
            }
            while (curR != dC) {
                System.out.print(maxtrix[curR++][curC] + " ");
            }

            while (curC != tC) {
                System.out.print(maxtrix[curR][curC--] + " ");
            }
            while (curR != tR) {
                System.out.print(maxtrix[curR--][curC] + " ");
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
        SpiralOrderPrint sop = new SpiralOrderPrint();
        sop.spiralOrderPrint(matrix);
    }
}
