package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.HashMap;

/**
 * 在二叉树中找到累加和为指定的最长路径长度
 *
 * 题目：
 *    给定一颗二叉树的头节点head 和 一个32位整数sum，二叉树节点值类型为整型，
 *    求累加和为sum的最长路径长度。路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所形成的节点链。
 */
public class GetMaxLength {

    /**
     *
     */
    public int getMaxLength(TreeNode head, int sum) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0); // 重要
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    /**
     * 前序递归 算路径和
     */
    private int preOrder(TreeNode head, int sum, int preSum, int level, int maxLen,
                         HashMap<Integer, Integer> sumMap) {


        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;

        // 将当前的路径和加入到 map中 记录下来
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        // 计算是否路径之前有路径和 之间相差 sum的key存在
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }

        maxLen = preOrder(head.left, sum, curSum, level+1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level+1, maxLen, sumMap);

        // 以cur为头节点的子树处理完，当然要返回搭配cur这个父节点，再返回前还有一项重要的工作要做，
        // 在sumMap中 查询 curSum 这个累加和(key)出现的层数（value），如果value等于level，说明curSum
        // 这个累加和的记录是在遍历cur时加上去的，那就把这一条记录删除。
        // 如果value 不等于level，则不做任何调整
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }

        return maxLen;
    }
}
