package Offer.Offer_54;

import java.util.PriorityQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
//    public int kthLargest(TreeNode root, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        dfs(root, queue);
//        int len = queue.size();
//        for (int i = 0; i < len - k; i++) {
//            queue.poll();
//        }
//        return queue.peek();
//    }
//    private void dfs(TreeNode root, PriorityQueue<Integer> queue ) {
//        if (root == null) return;
//
//        dfs(root.left, queue);
//        queue.offer(root.val);
//        dfs(root.right, queue);
//    }
    int k, res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k==0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
