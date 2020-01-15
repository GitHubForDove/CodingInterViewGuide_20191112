package CodingInterviewGuide.demo.Chapter7;


/**
 * 一行代码求两个数的最大公约数
 *
 * 题目：
 *  给定两个不等于 0 的整数 M 和 N，求 M 和 N 的最大公约数
 */
public class Gcd {

    public int gcd(int n, int m) {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static void main(String[] args) {
        Gcd g = new Gcd();
        int res = g.gcd(15,10);
        System.out.println(res);
    }
}
