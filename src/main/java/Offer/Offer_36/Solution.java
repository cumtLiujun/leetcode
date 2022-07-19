package Offer.Offer_36;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {
    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);


        head.left = pre;
        pre.right = head;
        return head;
    }

    //    二叉搜索树  中序遍历为增序序列
    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
