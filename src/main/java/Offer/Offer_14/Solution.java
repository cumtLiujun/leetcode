package Offer.Offer_14;

public class Solution {

//    数学推导  现在属实不会
    public int cuttingRope0(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
//        i 为绳子长度
        for (int i = 3;i<=n;i++) {
//            j 为修剪的长度
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(Math.max(i-j, dp[i-j]) * j, dp[i]);
            }
        }
        return dp[n];
    }

//    计算结果需要进行1000000007取模, 此处注意 数据类型的使用，使用高精度的long
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n-1;
        }
        int a = n / 3;
        int b = n % 3;
        long ans = 0;
        if (b == 0) {
           ans = pow(3, a);
        }

        if (b == 1) {
            ans = pow(3, a - 1) * 4 % 1000000007;
        }

        if (b == 2) {
            ans = pow(3, a) * 2 % 1000000007;
        }
        return (int) ans;
    }

    private long pow(int m, int n) {
        long res = 1;

        for (int i = 0; i < n; i++) {
            res = m * res % 1000000007;
        }
        return res;
    }
}
