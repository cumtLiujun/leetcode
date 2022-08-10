package Offer.Offer_68_II;

public class Solution {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

//        判断 p, q 节点是否在  root 左子树
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor1(root.left, p, q);
        }
//        判断p,q 节点是否是在 root 右子树
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor1(root.right, p, q);
        }
//        左右各一个，则返回root为最近公共祖先
        return root;
    }

    //寻找时间复杂度极高，废弃
    private boolean find(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;

        return find(root.left, target) || find(root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left == null && right != null) return right;
        else if (right == null && left != null) return left;
        else return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

