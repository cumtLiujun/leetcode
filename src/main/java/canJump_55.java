public class canJump_55  {
    /*
    题解：类似于贪心算法，只要左侧可以跳跃的最大距离大于当前位置，就可以到达当前位置
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length;i++) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
