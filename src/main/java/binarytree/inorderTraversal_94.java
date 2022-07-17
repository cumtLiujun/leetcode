package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal_94 {

    /*
    递归方法，中序遍历 先左子树再根节点，最后右子树
     */
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null ) return res;
        if (root != null) {
            inorderTraversal1(root.left);
            res.add(root.val);
            inorderTraversal1(root.right);
        }
        return res;
    }
    /*
    非递归方法，使用栈进行辅助，利用栈先进后出的特性；
     */

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;

    }
}
