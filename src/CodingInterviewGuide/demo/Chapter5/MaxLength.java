package CodingInterviewGuide.demo.Chapter5;


import java.util.Stack;

/**
 *  给定一个括号字符串 str, 返回最长的有效括号字串
 *  例如：
 *     str="(()())"，返回6; str="())"，返回2；str="()(()()("，返回4
 */
public class MaxLength {

    /**
     * dp动态规划 解决问题
     */
    public int maxLength(String str) {

        if (str == null || str.equals("")) {
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i=1; i< chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i-1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 使用栈  记录下 字符等于 '(' 的下标  当遇到')' 时 计算 子串长度
     *
     */
    public int longestValidParentheses(String s) {
        int maxnas = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxnas = Math.max(maxnas, i- stack.peek());
                }
            }
        }

        return maxnas;
    }

    /**
     * 方法 4：不需要额外的空间
     * 算法
     *
     * 在这种方法中，我们利用两个计数器 leftleft 和 rightright 。首先，我们从左到右遍历字符串，
     * 对于遇到的每个 \text{‘(’}‘(’，我们增加 leftleft 计算器，对于遇到的每个 \text{‘)’}‘)’ ，
     * 我们增加 rightright 计数器。每当 leftleft 计数器与 rightright 计数器相等时，
     * 我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。如果 rightright 计数器比 leftleft 计数器大时，
     * 我们将 leftleft 和 rightright 计数器同时变回 00 。
     *
     * 接下来，我们从右到左做一遍类似的工作。
     *
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0,maxLength = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLength = Math.max(maxLength, right*2);
            }else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLength = Math.max(maxLength, left*2);
            }else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }


        public static void main(String[] args) {
        MaxLength ml = new MaxLength();
        String s = "(()())";
        int res = ml.longestValidParentheses2(s);
        System.out.println(res);
    }

}
