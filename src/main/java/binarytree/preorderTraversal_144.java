package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {

    /*
    前序遍历，先根节点，再左子树，最后右子树；
     */

    public List<Integer> traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


    public List<Integer> traversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                node = tmp.right;
            }
        }
        return res;
    }
}
