package binarytree;

import java.util.HashMap;
import java.util.Map;

public class pathSum_437 {
//    方法1： dfs，暴力解法，双递归，深度优先搜索，寻找全部的可能答案
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
       return calPathSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int calPathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        targetSum -= root.val;
        int tmp = 0;
        if (targetSum == 0) {
            tmp ++;
        }
        return tmp + calPathSum(root.left, targetSum) + calPathSum(root.right, targetSum);
    }
//    前缀和：方法牛逼
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, prefixSumCount, sum, 0);

    }
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        if (node == null) return 0;
        int res = 0;

        currSum += node.val;

        res += prefixSumCount.getOrDefault(currSum - target, 0);
//        更新前缀和
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //        进入当前下一层左右子树
        int left = recursionPathSum(node.left, prefixSumCount, target, currSum);
        int right = recursionPathSum(node.right, prefixSumCount, target, currSum);

        res = res + left + right;
//        题目要求只是是父子节点之间，hashmap值传递指向同一块内存地址，需要一层一层清除本层的前缀和，以符合要求
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) - 1);
        return res;
    }

}
