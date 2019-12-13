package CodingInterviewGuide.demo.Chapter5;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 找到字符串的最长无重复字符字串
 *
 *  题目：
 *      给定一个字符串 str,返回 str的最长无重复字符字串的长度
 *
 *  例如：
 *    str = "abcd", 返回4
 *    str = "aabcd",最长无重复字符串为"abc"，返回3
 */
public class MaxUnique {

    public int maxUnique(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int pre = -1;
        int cur = 0;
        int len = 0;
        for (int i=0; i<chas.length; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }


    public int maxUnique2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int pre = 0;
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                pre = Math.max(map.get(s.charAt(i)), pre);
            }
            len = Math.max(i - pre + 1, len);
            map.put(s.charAt(i), i+1);
        }
        return len;
    }

    public static void main(String[] args) {
        MaxUnique mu = new MaxUnique();
        String str = "abba";
        int res = mu.maxUnique2(str);
        System.out.println(res);
    }
}
