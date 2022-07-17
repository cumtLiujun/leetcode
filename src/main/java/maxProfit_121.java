public class maxProfit_121 {
    /*
    买卖股票的最佳时机，贪心，在尽可能小的时候买入，尽可能大的时候买出；
     */
//    暴力解法，双指针，求出最优值, 超出时间限制，一般解体不能首先使用暴力解法
    public int maxProfit0(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = prices.length - 1; j > i; j--) {
                if (prices[i]<prices[j]) {
                    max = Math.max(max,(prices[j] - prices[i]) );
                }
            }

        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrices = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length;i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            } else if (prices[i] - minPrices > maxProfit) {
                maxProfit = prices[i] - minPrices;
            }
        }
        return maxProfit;
    }

}
