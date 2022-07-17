package binarytree;

public class isSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }
    public boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }

        return leftNode.val == rightNode.val && dfs(leftNode.left,rightNode.right) && dfs(rightNode.left,leftNode.right);
    }

}
