package CodingInterviewGuide.demo.Chapter9;


/**
 * 有关阶乘的两个问题
 *
 *  题目：
 *      给定一个非负整数N，返回N！结果的末尾为0的数量。
 *      例如： 3 != 6, 结果的末尾没有0，则返回0. 5! = 120,结果的末尾有 1个 0, 返回1。
 *      1000000000!,结果的末尾有249999998个0，返回249999998。
 *
 *  进阶题目：
 *      给定一个非负整数 N,如果用二进制表达 N!的结果，返回最低位的1在哪个位置上，认为最右的位置为 0.
 *      例如： 1 != 1,最低位的1在 0 位置上。 2 != 2, 最低位的1在1位置上。1000000000!,最低位的1在
 *      999999987 位置上。
 */
public class ZeroNum {
    /**
     * 如果把 N!的结果中因子5的总个数记为 Z,就可以得到如下关系：
     * Z = N/5 + N/(5^2) + N/(5^3) + ... + N/(5^i) (i 一直增长，直到 5^i > N)
     */
    public int zeroNum (int num) {
        if (num < 0) {
            return 0;
        }

        int res = 0;
        while (num != 0) {
            res += num / 5;
            num /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        ZeroNum zn = new ZeroNum();
        int res = zn.zeroNum(1000000000);
        System.out.println(res);
    }
}
