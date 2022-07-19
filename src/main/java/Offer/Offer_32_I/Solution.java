package Offer.Offer_32_I;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            res.add(tmp.val);
            if (tmp.left!=null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
        }
//        preorder(root, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

//    private void preorder(TreeNode root, ArrayList<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        res.add(root.val);
//        preorder(root.left, res);
//        preorder(root.right, res);
//    }
}
