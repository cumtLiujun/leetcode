package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxDepth_104 {
/*
广度优先搜索，感觉在这里略显得繁琐
 */
    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int max = 0;
        if (root == null) return max;
        queue.add(root);
        while (!queue.isEmpty()) {
            max++;
            int currentSize = queue.size();
            for (int i = 0;i<currentSize;i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left!=null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
        }
        return max;
    }
/*
深度优先搜索
 */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
