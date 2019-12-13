package CodingInterviewGuide.demo.Chapter5;


import java.util.Arrays;

/**
 * 翻转字符串
 *
 * 题目：
 *      给定一个字符类型的数组chas，请在单词间做逆序调整。只要做到单词顺序逆序即可，对空格的位置没有特别要求。
 *
 * 例如：
 *     如果把chas看作字符串未"dog loves pig"，调整为"pig Loves dog"。
 *     如果把chas看作字符串为"i'm a student"，调整为 "student. a i'm"。
 */
public class RotateWord {

    /**
     * 思路：
     *      将单词字符串全部翻转一次 ，然后再将每个单词 再返翻转一次
     * @param chas
     */
    public void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }

        reverse(chas, 0, chas.length -1);
        int l = -1;
        int r = -1;

        for (int i=0; i<chas.length; i++) {

            // 找每个单词 空格前后的下标
            if (chas[i] != ' ') {
                l = i == 0 || chas[i-1] == ' ' ? i : l;
                r = i == chas.length-1 || chas[i+1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }

    }

    public void reverse(char[] chas, int start, int end) {
        char temp;

        while (start < end) {
            temp = chas[start];
            chas[start] = chas[end];
            chas[end] = temp;
            start++;
            end-- ;
        }
    }


    public static void main(String[] args) {
        String str = "dog love pig";
        char[] chas = str.toCharArray();
        RotateWord rw = new RotateWord();
        rw.rotateWord(chas);
        System.out.println(Arrays.toString(chas));
    }
}
