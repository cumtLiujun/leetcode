package binarytree;

public class rob_337 {

    /*
    动态规划 + 有限状态
     */

//   root 节点偷不偷进行分析，时间复杂度很高
    public int rob(TreeNode root) {

        if (root == null) return 0;
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.right) + rob(root.left.left);
        }

        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money, rob(root.right) + rob(root.left));
    }

    public int rob1(TreeNode root) {
        if (root == null) return 0;
        int[] result = robStatus(root);
        return Math.max(result[0], result[1]);
    }

//    有限状态， 该节点 偷 or 不偷
    private int[] robStatus(TreeNode root) {
        if (root == null) return new int[2];

        int[] result = new int[2];

        int[] left = robStatus(root.left);
        int[] right = robStatus(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
