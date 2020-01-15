package CodingInterviewGuide.demo.Chapter5;


/**
 * 将整数字符串转成整数值
 *
 * 题目：
 *    给定一个字符串str， 如果str符合日常书写的整数形式，并且属于32为整数的范围，
 *    返回str 所代表的整数值。否则，返回0。
 */
public class Convert {


    /**
     * 思路：
     *   首先 ： 判断这个整数字字符串是否是整数字符串 符合规定
     */

    public int convert(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }

        char[] chars = str.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }

        boolean posi = chars[0] != '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i<chars.length; i++) {
            // 不管 负数还是正数 都用负数来进行计算
            cur = '0' - chars[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                return 0;
            }

            res = res * 10 + cur;
        }

        if (posi && res == Integer.MIN_VALUE) {
            return 0;
        }

        return posi ? -res : res;
    }

    /**
     * 判断字符串是否是有效的数字字符串
     */
    public boolean isValid(char[] chars) {
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return false;
        }

        if (chars[0] == '0' && (chars.length == 1 || chars[1] == '0')) {
            return false;
        }

        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }

        for (int i=1; i<chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        Convert convert = new Convert();
        int res = convert.convert(str);
        System.out.println(res);
    }


}
