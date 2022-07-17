package dp;

public class maxProfit_309 {
    /*
    动态规划：状态转移
    根据题目描述可知又三种状态：
    dp[i][0] 有股票
    dp[i][1] 无股票且处于冷冻期
    dp[i][2] 无股票且不处于冷冻期
     */
    public int maxProfit0(int[] prices) {
        int len = prices.length;

        int[][] dp = new int[len][3];
        dp[0][0] = - prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i -1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }

        return Math.max(dp[len -1][1], dp[len -1][2]);
    }

    /*
    方法2：有限状态方法
    结果和三种状态相关
    1、持有股票
    2、处于冷冻期
    3、不持有股票，且不处于冷冻期
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;

        for (int i = 1; i < len; i++) {
            int tmp0 = Math.max(dp0, dp2-prices[i]);
            int tmp1 = dp0 + prices[i];
            int tmp2 = Math.max(dp2, dp1);

            dp0 = tmp0;
            dp1 = tmp1;
            dp2 = tmp2;
        }

        return Math.max(dp1,dp2);
    }

}
