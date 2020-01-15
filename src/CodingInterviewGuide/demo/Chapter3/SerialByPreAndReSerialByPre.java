package CodingInterviewGuide.demo.Chapter3;


import Utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化 与  反序列化
 *
 * 题目：
 *    二叉树被记录成文件的过程叫做二叉树的序列化，通过文件内容重建原来二叉树的过程叫作二叉树的反序列化。
 *    给定一棵二叉树的头节点head， 并已知二叉树节点值的类型为32位整型。 请设计一种二叉树序列化和反序列化的方案，
 *    并用代码实现。
 */
public class SerialByPreAndReSerialByPre {

    public String serialByPre(TreeNode head) {

        if (head == null) {
            return "#!";
        }

        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);

        return res;
    }

    public TreeNode reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));

        return reconPreOrder(queue);
    }

    public TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value == null || value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);

        return node;
    }


    public String serialByLevel(TreeNode head) {
        if (head == null) {
            return "#!";
        }

        StringBuilder res = new StringBuilder(head.value + "!");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                res.append(node.left.value).append("!");
                queue.offer(node.left);
                //node = node.left;
            } else {
                res.append("#!");
            }

            if (node.right != null) {
                res.append(node.right.value).append("!");
                queue.offer(node.right);
            } else {
                res.append("#!");
            }
        }

        return res.toString();
    }

    public TreeNode reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        if (values.length == 0) {
            return null;
        }

        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.left);
            }
        }

        return head;
    }

    /**
     * 生成树节点
     */
    public TreeNode generateNodeByString(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(12);
        head.left = new TreeNode(3);
        head.right = new TreeNode(15);
        SerialByPreAndReSerialByPre sbarsbp = new SerialByPreAndReSerialByPre();
        String res = sbarsbp.serialByPre(head);
        System.out.println(res);

        TreeNode node = sbarsbp.reconByPreString(res);

        System.out.println(node.value);
        System.out.println(node.left.value);
        System.out.println(node.right.value);

        res = sbarsbp.serialByLevel(head);
        System.out.println(res);
        //System.out.println(node.right.value);

        node = sbarsbp.reconByLevelString(res);

        System.out.println(node.value);
        System.out.println(node.left.value);
        System.out.println(node.right.value);
    }
}
