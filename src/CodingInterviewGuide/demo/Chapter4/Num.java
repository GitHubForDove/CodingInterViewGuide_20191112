package CodingInterviewGuide.demo.Chapter4;


/**
 * 数字字符串转为字母组合的种数
 *
 * 题目：
 *  给定一个字符串 str, str 全部由数字字符组成，如果 str 中某个或者相邻两个字符串组成的字串
 *  在 1~26之间，则这个字串可以转换成一个字母。规定 “1”转化为 “A”，“2”转换为“B”，“3”转换为“C”。。。“26”转换为“Z”。
 *  写一个函数，求 str 有多少种不同的转换结果，并返回种数。
 */
public class Num {

    public int num1(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chs1 = str.toCharArray();
        return func(chs1, 0);
    }

    private int func(char[] chs1, int i) {
        if (i == chs1.length) {
            return 1;
        }
        if (chs1[i] == '0') {
            return 0;
        }

        int res = func(chs1, i + 1);

        if (i + 1 < chs1.length || (chs1[i] - '0') * 10 + chs1[i + 1] - '0' < 27) {
            res += func(chs1, i + 2);
        }
        return res;
    }


    public int num2(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chs1 = str.toCharArray();
        int cur = chs1[chs1.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for (int i = chs1.length - 2; i >= 0; i--) {

            if (chs1[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                tmp = cur;
                if ((chs1[i] - '0') * 10 + chs1[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = tmp;
            }
        }
        return cur;
    }
}
