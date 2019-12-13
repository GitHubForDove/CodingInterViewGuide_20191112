package CodingInterviewGuide.demo.Chapter5;


/**
 * 括号字符串的有效性和最长有效长度
 *
 * 题目：
 *    给定一个字符串 str,判断是不是整体有效的括号字符串
 *
 * 举例：
 *    str="()",返回true;str="(()())",返回true;str="(())"，返回true。
 *    str="())"。返回false；str="()("，返回false；str="()a()",返回false。
 */
public class IsValid {

    public boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }

        char[] chas = str.toCharArray();
        int status = 0;
        for (int i=0; i<chas.length; i++) {
            if (chas[i] != '(' && chas[i] != ')') {
                return false;
            }
            if (chas[i] == ')' && --status < 0) {
                return false;
            }
            if (chas[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

    public static void main(String[] args) {
        String str = "(()())";
        IsValid iv = new IsValid();
        boolean res = iv.isValid(str);
        System.out.println(res);
    }
}
