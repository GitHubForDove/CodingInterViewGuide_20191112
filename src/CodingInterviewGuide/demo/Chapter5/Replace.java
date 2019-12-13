package CodingInterviewGuide.demo.Chapter5;


/**
 * 替换字符串中连续出现的指定字符串
 *
 * 题目：
 *   给定三个字符串 str、from 和 to， 一直from字符串中无重复字符，把str中所有from的字串全部替换成to字符串，
 *   对连续出现from的部分要求只替换成一个to字符串，返回最终的结果字符串。
 */
public class Replace {

    public String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return str;
        }

        char[] chars = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == chaf[match++]) {
                if (match == chaf.length) {
                    clear(chars, i, chaf.length);
                    match = 0;
                }
            } else {
                if (chars[i] == chaf[0]) {
                    // 退回一步 下次比较还是当下的i下表的位置
                    i--;
                }
                match = 0;
            }
        }

        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] != 0) {
                cur.append(chars[i]);
            }
            // 加入的时机
            if (chars[i] == 0 && (i == 0 || chars[i-1] != 0)) {
                res.append(cur).append(to);
                cur = new StringBuilder();
            }
        }
        if (!cur.equals("")) {
            res.append(cur);
        }
        return res.toString();
    }

    private void clear(char[] chars, int end, int len) {
        while (len-- != 0) {
            chars[end--] = 0;
        }
    }

    public static void main(String[] args) {
        String str = "123abcabcabc123abcabcab", from = "abc", to = "x";
        Replace r = new Replace();
        String res = r.replace(str, from, to);
        System.out.println(res);
    }
}
