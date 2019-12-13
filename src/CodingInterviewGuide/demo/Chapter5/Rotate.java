package CodingInterviewGuide.demo.Chapter5;


import java.util.Arrays;

/**
 * 给定一个字符类型的数组chas 和一个正数size,请把大小为size的左半区整体移动到右半区，右半区移动到左边。
 */
public class Rotate {

    public void rotate(char[] chas, int size) {
        if (chas == null || size <= 0 || size >= chas.length) {
            return;
        }

        reverse(chas, 0, size-1);
        reverse(chas, size, chas.length-1);
        reverse(chas, 0, chas.length-1);
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
        String str = "ABCDE";
        char[] chas = str.toCharArray();
        Rotate rotate = new Rotate();
        rotate.rotate(chas, 2);
        System.out.println(Arrays.toString(chas));
    }
}
