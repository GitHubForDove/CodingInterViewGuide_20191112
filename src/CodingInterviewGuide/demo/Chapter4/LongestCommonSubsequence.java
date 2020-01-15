package CodingInterviewGuide.demo.Chapter4;


/**
 * 最长公共子序列问题
 *
 * 题目：
 *
 *  给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 */
public class LongestCommonSubsequence {

    public int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
        }


        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j-1], str1[0] == str2[j] ? 1 : 0);
        }

        for (int i=1; i<str1.length; i++) {
            for (int j=1; j<str2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }

        return dp;
    }

    /**
     * 通过dp求解最长公共子序列的过程就是还原出当时如何求解dp的过程，
     * 来自哪个策略就朝哪个方向移动。
     */
    public String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int m = chs1.length-1;
        int n = chs2.length-1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;

        while (index >= 0) {
            if ( n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m-1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1+1][len2 +1];

        // 使用自顶向下的解法
        for (int i=len1-1; i>= 0; i--) {
            for (int j=len2-1; j>=0; j--) {

                dp[i][j] = dp[i+1][j+1];
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j]++;
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }




    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int[][] res = lcs.getdp(s1.toCharArray(), s2.toCharArray());
        System.out.println(res[res.length-1][res[0].length-1]);
        String str = lcs.lcse(s1, s2);
        System.out.println(str);
    }
}
