package CodingInterviewGuide.demo.Chapter4;


/**
 * 斐波那契系列问题的递归和动态规划
 *
 * 题目:
 *  给定整数N,返回斐波那契数列的第N项
 *
 * 补充题目 1
 *  给定整数N,代表台阶数,一次可以跨2个或者1个台阶,返回有多少种走法.
 *
 * 补充题目2
 *  假设农场中成熟的母牛每年只会生1头小母牛,并且永远不会死.第一年农场有1只成熟的母牛,从第二年开始,母牛开始生小母牛.
 *  每只小母牛3年之后成熟又可以生小母牛.给定整数 N , 求出 N年后 牛的数量
 */
public class Fibonacci {

    /**
     * 暴力 递归
     */
    public int f1(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return f1(n-1) + f1(n-2);
    }

    public int f2(int n) {
        if (n < 1) {
            return 0;
        }

        int res = 1;
        int pre = 1;
        int temp = 0;

        for (int i=3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[][] base = {{1,1}, {1,0}};
        int[][] res = matrixPow(base, n -2);
        return res[0][0] + res[1][0];
    }

    private int[][] matrixPow(int[][] base, int p) {
        int[][] res = new int[base.length][base[0].length];

        // 先把res 设为单位矩阵,相当于整数中的 1
        for (int i=0; i<res.length; i++) {
            res[i][i] = 1;
        }

        int[][] temp = base;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, temp);
            }
            temp = muliMatrix(temp, temp);
        }
        return res;
    }

    private int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m1[0].length];
        for (int i=0; i<m1.length; i++) {
            for (int j=0; j<m2[0].length; j++) {
                for (int k=0; k<m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }


    /**
     * 补充问题 1
     */

    /**
     * 暴力 递归
     */
    public int s1(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        return f1(n-1) + f1(n-2);
    }


    public int s2(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int res = 2;
        int pre = 1;
        int temp = 0;

        for (int i=3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    /**
     * 补充问题 2
     * f(n) = f(n-1) + f(n-3)
     */
    public int c2(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2 || n == 3) {
            return n;
        }

        int res = 3;
        int pre = 2;
        int prepre = 1;
        int temp1 = 0;
        int temp2 = 0;

        for (int i=4; i <= n; i++) {
            temp1 = res;
            temp2 = pre;
            res += prepre;
            pre = temp1;
            prepre = temp2;
        }
        return res;
    }


    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int res = f.c2(50);
        System.out.println(res);
    }
}
