package dp;

public class rob_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len == 1 ? nums[0] : Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[len];
        dp[0] = nums[0];dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
}
