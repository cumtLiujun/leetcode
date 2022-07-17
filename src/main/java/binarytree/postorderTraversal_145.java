package binarytree;

import java.util.*;

public class postorderTraversal_145 {
    /*
    后续遍历，先左子树，再右子树，最后根节点
     */

    public List<Integer> traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorder(root,res);

        return res;

    }

    public void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);

    }


/*
后续遍历：left->right->root => root->right->left
1、按照原来顺序迭代比较困难， reverse之后做法与前序遍历类似
2、按照root->right->left之后，将结果reverse
3、此方法相对加了reverse，时间消耗大
 */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root= root.right;
            }
            TreeNode tmp = stack.pop();
            root = tmp.left;
        }
        Collections.reverse(res);
        return res;
    }

//利用双向链表，后插变前插，实现上述逆向假设
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                res.addFirst(root.val);
                stack.push(root);
                root= root.right;
            }
            TreeNode tmp = stack.pop();
            root = tmp.left;
        }
        return res;
    }


}
