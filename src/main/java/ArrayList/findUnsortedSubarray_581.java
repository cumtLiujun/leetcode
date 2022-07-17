package ArrayList;

import java.util.Arrays;

public class findUnsortedSubarray_581 {
    /**
     * 排序 + 双指针
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0;
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = 0;
        int right = len -1;
        while(left <= right && nums[left] == clone[left]) left++;
        while(left <= right && nums[right] == clone[right]) right--;
        return right - left + 1;
    }
}
