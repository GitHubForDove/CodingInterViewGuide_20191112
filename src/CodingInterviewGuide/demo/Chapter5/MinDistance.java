package CodingInterviewGuide.demo.Chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 数组中两个字符串的最小距离
 *
 * 题目：
 *    给定一个数组strs，再给定两个字符串 str1 和 str2， 返回在strs中str1与str2的最小距离，如果str1 或 str2为null，
 *    或不在strs中，返回-1。
 */
public class MinDistance {


    public int minDistance(String[] strs, String str1, String str2) {

        if (strs == null || str1 == null || str2 == null) {
            return -1;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.min(min, last2 == -1 ? min : i-last2);
                last1 = i;
            }
            if (strs[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"1123123","23","3231","3","2","3","1"};
        String str1 = "1", str2 = "2";
        Optional<String> res = Arrays.stream(strs)
                .filter(str -> str.length() >= 4)
                .findFirst();

        List<String> temp = new ArrayList<>();
        Arrays.stream(strs).forEach(s -> {
            if (s.length() >= 4) {
                temp.add(s);
            }
        });
        System.out.println(temp);
        MinDistance md = new MinDistance();
        int index = md.minDistance(strs, str1, str2);
        System.out.println(index);
    }
}
