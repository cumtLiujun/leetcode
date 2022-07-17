package ArrayList;

public class findTargetSumWays_494 {

    /*
    方法1： 回溯法
     */
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrace(nums, 0, target, 0);
        return res;
    }

    private void backTrace(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (target == sum) {
                res++;
            }
            return;
        }

        int num = nums[index];
        backTrace(nums, index + 1, target, sum + num);
        backTrace(nums, index + 1, target , sum - num);
    }

    /*
    方法二，记忆化搜索，使用记忆化容器来记录遍历过程中的值，遇到符合的情况直接返回，不进行下一步的遍历

     */

}
