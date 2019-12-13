package CodingInterviewGuide.demo.Chapter5;


/**
 * 最小包含字串的长度
 *
 * 给定字符串 str1 和 str2 ，求str1的字符串中包含有 str2所有字符的最小字串长度
 */
public class MinLength {

    public int minLength(String s1, String s2) {
        if (s2 == null || s2.equals("")) {
            return 0;
        }
        int len = 0;
        for (int i=0; i<s1.length(); i++) {

            for (int j=0; j<s2.length();j++) {

            }
        }

        return 0;
    }

}
