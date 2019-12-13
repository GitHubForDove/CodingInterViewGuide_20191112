package CodingInterviewGuide.demo.Chapter5;

/**
 * 判读两个字符串是否互相为变形词
 *
 *  题目：
 *     给定两个字符串str1 和 str2 如果 str1 和 str2中出现的字符种类一样且每种字符出现的次数也一样，
 *     那么 str1 和 str2互为变形词。请实现函数判断两个字符串是否为变形词。
 */
public class IsDeformation {

    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        int[] map = new int[256];
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        for (int i=0; i<c1.length; i++) {
            map[c1[i]]++;
        }

        for (int j=0; j<c2.length; j++) {
            if (map[c2[j]] -- == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "322";
        boolean res = isDeformation(str1, str2);
        System.out.println(res);
    }
}
