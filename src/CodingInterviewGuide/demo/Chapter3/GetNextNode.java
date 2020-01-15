package CodingInterviewGuide.demo.Chapter3;


/**
 * 在二叉树中找到一个节点的后继节点
 *
 * 题目：
 * 现在有一种新的二叉树结构节点类型如下：
 *
 * public class Node {
 *     public int value;
 *     public Node right;
 *     public Node parent;
 *
 *     public Node(int data) {
 *        this.value = data;
 *     }
 * }
 *
 * 这个结构比普通的二叉树结构多了一个指向父节点的parent指针。假设有一颗 Node 类型的节点组成的二叉树，树中每个节点的 parent指针
 * 都正确地指向自己的父节点，头节点的parent 指向null。只给一个在二叉树中的某一个节点node，请实现返回node的后继节点的函数.
 * 在二叉树的中序遍历的序列中,node的下一个节点叫作 node 的后继节点.
 */
public class GetNextNode {

    public class Node {
        public int value;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node getNextNode(Node node) {
        if (node == null) {
            return node;
        }

        return null;
    }

}
