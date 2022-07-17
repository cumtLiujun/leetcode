package binarytree;

public class maxPathSum_124 {
    /*
    二叉树最大路径和，三个关键点：某子树内部最大值，某子树向外部提供的最大值，全局最大值
    递归返回的是当前节点能够提供的最大值
     */
//    用于更新结果
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return  res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
//       递归默认已经找到结果
        int left = dfs(root.left);
        System.out.println("left" + left);
        int right = dfs(root.right);
        System.out.println("right" +right);

        res = Math.max(res, root.val + left + right);
//        当前位置能提供的最大值
        int max = Math.max(root.val + left, root.val + right);
//       若是当前子树对最大路径和无贡献，返回0，表示不从此路
        return Math.max(max, 0);

    }

}
