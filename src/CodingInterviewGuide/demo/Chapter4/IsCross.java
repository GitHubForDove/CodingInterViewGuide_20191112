package CodingInterviewGuide.demo.Chapter4;


/**
 * 字符串的交错组成
 *
 * 题目：
 *  给定三个字符串 str1、str2 和 aim，如果aim包含且仅包含来自 str1 和 str2 的所有字符，而且在aim中属于str1
 *  的字符串之间保持原来的顺序，属于str2的字符之间保持原来str2中的顺序，那么称aim是str1和str2的交错组成。实现
 *  一个函数，判断aim是否是str1和受str2交错组成。
 *
 *  举例：
 *  str1 = ”AB“，str2=”12“。那么 ”AB12”、“A1B2”、“A12B”、"1A2B" 和 “1AB2”等都是str1和str2的交错组成。
 */
public class IsCross {

    public boolean isCross(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (chs1.length + chs2.length != chaim.length) {
            return false;
        }

        boolean[][] dp = new boolean[chs1.length+1][chs2.length+1];
        dp[0][0] = true;
        for (int i=1; i<= chs1.length; i++) {
            if (chaim[i-1] != chs1[i-1] ) {
                break;
            }
            dp[i][0] = true;
        }

        for (int j = 1; j <= chs2.length; j++) {
            if (chaim[j - 1] != chs2[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i=1; i<= dp.length; i++) {
            for (int j=1; j<= dp[0].length; j++) {
                if ((chs1[i-1] == chaim[i+j-1] && dp[i-1][j])
                        || (chs2[j -1] == chaim[i+j-1] && dp[i][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[chs1.length][chs2.length];
    }
}
