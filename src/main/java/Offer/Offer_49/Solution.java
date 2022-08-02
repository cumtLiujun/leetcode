package Offer.Offer_49;

public class Solution {
    //    动态规划：类似于上中下 三种马进行跑，速度慢的先跑，直至路程跑的远了之后；
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a, b, c;
        int i = 0, j = 0, k = 0;
        for (int m = 1; m < n; m++) {
            a = dp[i] * 2;
            b = dp[j] * 3;
            c = dp[k] * 5;
            int temp = Math.min(Math.min(a, b), c);
            dp[m] = temp;
            if (a == temp) i++;
            if (b == temp) j++;
            if (c == temp) k++;
        }
        return dp[n - 1];
    }


}
