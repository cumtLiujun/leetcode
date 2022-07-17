package binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class buildTree_105 {
    /*
    方法1：递归构造二叉树
     */
    private Map<Integer, Integer> indexMap;
    public TreeNode bfs(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderRight < preorderLeft) {
            return null;
        }
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        int subLeftTree = inorderRoot - inorderLeft;
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        root.left = bfs(preorder,inorder,preorderLeft + 1, preorderLeft + subLeftTree, inorderLeft,inorderRoot -1);
        root.right = bfs(preorder,inorder,preorderLeft + subLeftTree + 1, preorderRight,inorderRoot + 1, inorderRight);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i< length; i ++) {
            indexMap.put(inorder[i], i);
        }
        return bfs(preorder,inorder,0,length-1,0,length-1);
    }
    /*
    方法2：迭代方法
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        int inorderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                   回退到有右子树的节点
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }
}
