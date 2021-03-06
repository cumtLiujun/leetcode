package Offer.Offer_42;

public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
