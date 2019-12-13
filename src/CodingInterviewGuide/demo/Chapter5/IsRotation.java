package CodingInterviewGuide.demo.Chapter5;

/**
 * 判断两个字符串是否是互为旋转词
 *
 * 如果一个字符串str， 把字符串str前面任意部分挪到后面形成的字符串叫做str的旋转词。
 * 比如 str="12345"，str的旋转词有"12345"、"23451"、"34512"、"45123"和"51234"。
 * 给定两个字符串 a 和 b，请判断a和b是否互为旋转词
 */
public class IsRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String s3 = s2 + s2;

        boolean res = s3.contains(s1);
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcde",s2 = "abced";
        boolean res = isRotation(s1,s2);
        System.out.println(res);
    }
}
