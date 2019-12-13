package CodingInterviewGuide.demo.Chapter5;


/**
 * 去掉字符串中连续出现K个0的字串
 *
 * 题目：
 *     给定一个字符串str 和 一个整数k，如果str中正好有连续的k个'0'字符出现时，
 *     把k个连续的'0'字符去除，返回处理后的字符串。
 */
public class RemoveKZero {

    public static String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }

        int count = 0;
        int start = -1;
        char[] chars = str.toCharArray();
        for (int i=0; i< chars.length; i++) {

            if (chars[i] == '0') {
               count++;
               start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        chars[start++] = 0;
                    }
                }
                // 重新置为初始值 用来做下一次的循环
                count = 0;
                start = -1;
            }
        }

        if (count == k) {
            while (count-- != 0) {
                chars[start++] = 0;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] != 0) {
                res.append(chars[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String str = "A00B";
        String res = removeKZeros(str, 2);
        System.out.println(res);
    }
}
