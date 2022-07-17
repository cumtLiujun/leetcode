package dp;

import java.util.Arrays;

public class lengthOfLIS_300 {
    /*
    动态规划1：找出动态转移方程 dp[i]的含义为以nums[i]结尾的最长严格递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < len; i++) {
            for (int j = 0;j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
    动态规划2：动态规划思想+二分法
    使用数组tail 动态更新 tail中最后一个数字  代表 len下最小的数字，用二分更新tail
    当nums[i]大于tail[len-1]时 即 res=j时res++;
     */

    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        int res = 0;
        for (int num: nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tail[mid] < num) i = mid + 1;
                else j = mid;
            }

            tail[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}
