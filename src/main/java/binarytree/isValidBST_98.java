package binarytree;

public class isValidBST_98 {
    /*
    方法1：递归
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;

        if (root.val >=upper || root.val <= lower) return false;

        return isValidBST(root.left,lower, root.val) && isValidBST(root.right, root.val, upper);
    }
    /*
    方法2：中序遍历，根据规律可以，从小到大，一次为左子树，root，右子树，符合中序遍历规则
     */
    private long lower = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)) return false;

        if (root.val <= lower) return false;

        lower = root.val;
        return isValidBST(root.right);
    }

}
