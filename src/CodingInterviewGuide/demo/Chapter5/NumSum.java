package CodingInterviewGuide.demo.Chapter5;


/**
 * 字符串中数字字串的求和
 *
 * 给定一个字符串str，求其中全部字符串所代表的数字之和
 *
 * 举例： str="A1CD2E33",返回36
 *       str="A-1B--2C--D6E",返回7
 *
 */
public class NumSum {

    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i=0; i<chars.length; i++) {
            cur = chars[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (chars[i] == '-') {
                    if (i-1 > -1 && chars[i-1] == '-') {
                        posi = true;
                    } else {
                        posi = false;
                    }
                }
            } else {
                num = num*10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        String str = "A-1B--2C--D6E";
        String str2 = "A1CD2E33";
        int res = numSum(str2);
        System.out.println(res);

    }
}
