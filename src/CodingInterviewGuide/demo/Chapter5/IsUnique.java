package CodingInterviewGuide.demo.Chapter5;


/**
 * 判断字符数组中是否所有的字符都只出现过一次
 *  题目：
 *     给定一个字符类型数组chars[],判断所有chas中是否所有的字符都只出现过一次，请根据以下两种不同的要求实现两个函数。
 *
 *     例如:
 *     chas = [‘a’,'b','c']，返回true；chas=['1','2','1']，返回false。
 */
public class IsUnique {

    /**
     * 使用字符数组标志 前面遍历过的字符 后续如果遇到相同的字符 就说明重复出现了
     */
    public boolean isUnique(char[] chas) {
        if (chas == null) {
            return true;
        }

        boolean[] map = new boolean[256];
        for (int i=0; i<chas.length; i++) {
            if (map[chas[i]]) {
                return false;
            }
            map[chas[i]] = true;
        }

        return true;
    }

    /**
     * 使用堆排序 解决问题  待解决
     */

    public static void main(String[] args) {
        char[] chas = new char[]{'1','2','1'};
        IsUnique iu = new IsUnique();
        boolean res = iu.isUnique(chas);
        System.out.println(res);
    }
}
