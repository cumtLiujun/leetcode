package Offer.offer_55_II;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
//    题目为任一节点，左右子树深度相差不能大于1；
    @Deprecated
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDeep(root.left) - maxDeep(root.right)) <= 1;
    }
    @Deprecated
    private int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }


}
