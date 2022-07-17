package dp;

import java.util.Arrays;
import java.util.regex.Pattern;

public class maxProduct_152 {
    /*
    失败方法，由于负数的影响，会导致最大值和最小值出现逆转
     */
    public int maxProduct0(int[] nums) {
        int len = nums.length;
        long[] dp = new long[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
        }
        Arrays.sort(dp);
        return (int) dp[len-1];
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int imax = nums[0],imin = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);

            max = Math.max(imax,imin);
        }
        return max;
    }
}
