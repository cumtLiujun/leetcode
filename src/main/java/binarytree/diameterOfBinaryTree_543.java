package binarytree;

public class diameterOfBinaryTree_543 {
    /*
    求左右子树的最大长度相加， 二叉树最大深度相关题型
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;

    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            max = Math.max(max,leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
