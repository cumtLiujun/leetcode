package Offer.Offer_55;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
//    int res = 0;
//
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        dfs(root, 0);
//        return res;
//    }
//
//    private void dfs(TreeNode root, int deep) {
//        if (root == null) {
//            res = Math.max(res, deep);
//            return;
//        }
//        dfs(root.left, deep + 1);
//        dfs(root.right, deep + 1);
//    }

//    正规dfs.jpg
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
