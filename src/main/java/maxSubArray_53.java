public class maxSubArray_53 {
/*
动态规划典型题目，需要得出动态规划方程
 */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i<length; i++){
//            状态转移方程
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int res = dp[0];
        for (int i = 1;i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
