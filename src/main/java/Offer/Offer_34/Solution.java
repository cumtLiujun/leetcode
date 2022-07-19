package Offer.Offer_34;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, target, 0, res, path);
        return res;
    }

    private void dfs(TreeNode root, int target, int sum, ArrayList<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum += root.val;
//        确保为叶子节点；
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target, sum, res, path);
        dfs(root.right, target, sum, res, path);
        path.remove(path.size()-1);
    }
}
