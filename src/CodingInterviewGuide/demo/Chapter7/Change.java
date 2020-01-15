package CodingInterviewGuide.demo.Chapter7;


/**
 * 不用额外变量交换两个整数的值
 *
 * 题目：
 * 如何不用任何额外变量交换两个整数的值？
 */
public class Change {

    public void change(int a, int b) {
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("a: " + a + " b: " + b);
    }

    public void change1(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + " b: " + b);
    }

        public static void main(String[] args) {
        Change c = new Change();
        c.change1(1,2);
    }
}
