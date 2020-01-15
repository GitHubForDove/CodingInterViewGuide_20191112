package CodingInterviewGuide.demo.Chapter5;


/**
 * 最小包含字串的长度
 *
 * 给定字符串 str1 和 str2 ，求str1的字符串中包含有 str2所有字符的最小字串长度
 */
public class MinLength {

    public int minLength(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return 0;
        }
        char[] chas1 = s1.toCharArray();
        char[] chas2 = s2.toCharArray();
        int[] map = new int[256];
        for (int i=0; i != chas2.length; i++) {
            map[chas2[i]]++;
        }

        int left = 0;
        int right = 0;
        int match = chas2.length;
        int minLen = Integer.MAX_VALUE;
        while (right != chas1.length) {
            map[chas1[right]]--;
            if (map[chas1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[chas1[left]] < 0) {
                    map[chas1[left++]]++;
                }
                minLen = Math.min(minLen, right - left +1);
                match++;
                map[chas1[left++]]++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
