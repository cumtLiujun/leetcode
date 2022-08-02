package Offer.Offer_46;

public class Solution {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String temp = str.substring(i - 2, i);
            dp[i] = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
        }
        return dp[len];
    }

    public int translateNum1(int num) {
        int a = 1, b = 1;
        int x, y = num % 10;
        while (num / 10 != 0) {
            num = num / 10;
            x = num % 10;
            int temp = x * 10 + y;
            int c = temp >= 10 && temp <= 25 ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
