package dp;

public class trap_42 {
/*
   方法1： 动态规划
   1、正向遍历数组得到从左往右看到的最大值
   2、反向遍历数组得到从右往看到的最大值
   3、结合两个最大值算出
 */
    public int trap(int[] height) {
//      入参判断
        int length = height.length;
        if (length < 3) return 0;
//        数据初始化
        int[] left_max = new int[length];
        int[] right_max = new int[length];
        int res = 0;
//        初始化 动态规划数组值
        left_max[0] = height[0];
        right_max[length-1] = height[length-1];

        for (int i = 1; i < length; i++) {
            left_max[i] = Math.max(left_max[i-1],height[i]);
        }

        for (int i = length-2; i >= 0 ; i--) {
            right_max[i] = Math.max(right_max[i+1], height[i]);
        }
        for (int i = 0; i < length; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }
}
