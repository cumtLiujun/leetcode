package binarytree;

public class lowestCommonAncestor_236 {
    /*
    递归：DFS 寻找最近的公共祖先
    每一层去寻找p和q的位置
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;

    }
}
