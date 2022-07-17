package binarytree;

public class numTrees_96 {

    /*
    动态规划，将n个序列分为从i分为大于和小于的左右子树，进而分解为两个子问题，使用动态规划方法进行求解
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
