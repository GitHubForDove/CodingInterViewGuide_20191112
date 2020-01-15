package CodingInterviewGuide.demo.Chapter4;

/**
 * 最长公共字串问题
 *
 * 题目：
 *  给定两个字符串 str1 和 str2，返回两个字符串的最长公共字串。
 *
 *  举例：
 *      str1 = "1AB2345CD", str2 = "12345EF", 返回"2345"。
 */
public class LCST {

    public int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j<str2.length; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i<str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }

    public String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("")) {
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int end = 0;
        int max = 0;

        // 找到最大值的下标 减去最大值 就是开始的位置
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String str1 = "1AB2345CD", str2 = "12345EF";
        LCST lcst = new LCST();
        int[][] dp = lcst.getdp(str1.toCharArray(), str2.toCharArray());
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        String res = lcst.lcst1(str1, str2);
        System.out.println(res);
    }
}
