package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class mergeTrees_617 {
    /*
    递归相加，深度优先搜索
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 :root1;
        }
        return dfs(root1, root2);

    }

    public TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }
    /*
    迭代方法，广度优先搜索
     */
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 :root1;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            r1.val += r2.val;
            if (r1.left!=null&&r2.left!=null) {
                queue.add(r1.left);
                queue.add(r2.left);
            } else if(r1.left == null) {
                r1.left = r2.left;
            }

            if (r1.right!=null&&r2.right!=null) {
                queue.add(r1.right);
                queue.add(r2.right);
            } else if(r1.right == null) {
                r1.right = r2.right;
            }
        }
        return root1;
    }

}
