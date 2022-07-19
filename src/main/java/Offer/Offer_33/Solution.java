package Offer.Offer_33;

public class Solution {
    /*
    1、先判断根节点所在的二叉搜索树是否正确
    2、 再递归判断左右子树是否为二叉搜索树
     */
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length -1);
    }

    private boolean dfs(int[] postorder, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int i = begin;
        while (postorder[i] < postorder[end]) i++;
        int m = i;
        while (postorder[i] > postorder[end]) i++;

        return i == end && dfs(postorder, begin, m -1) && dfs(postorder, m , end - 1);
    }


}
