package binarytree;

import java.util.List;

public class convertBST_538 {
    int res = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        res += root.val;
        root.val = res;
        convertBST(root.left);
        return root;
    }

}
