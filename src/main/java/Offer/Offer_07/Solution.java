//package Offer.Offer_07;
//
//import binarytree.TreeNode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Solution {
//
//    private Map<Integer, Integer> index;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int len = preorder.length;
//        if (len == 0) {
//            return null;
//        }
//        index = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            index.put(inorder[i], i);
//        }
//        return dfs(preorder, inorder, 0, len -1, 0 , len - 1);
//
//    }
//
//    private TreeNode dfs(int[] preorder, int[] inorder,int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
//        if (preorderRight < preorderLeft) {
//            return null;
//        }
//
//        int rootIndex = index.get(preorder[preorderLeft]);
//        int subLeft = rootIndex - inorderLeft;
//        TreeNode root =  new TreeNode(preorder[preorderLeft]);
//        root.left = dfs(preorder, inorder, preorderLeft + 1, preorderLeft + subLeft, inorderLeft,
//                rootIndex-1);
//        root.right = dfs(preorder, inorder, preorderLeft + subLeft + 1, preorderRight,
//                rootIndex + 1, inorderRight);
//        return root;
//    }
//}
