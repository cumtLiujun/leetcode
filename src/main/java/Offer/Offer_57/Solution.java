package Offer.Offer_57;

public class Solution {
//    双指针
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                break;
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[]{nums[i],nums[j]};
    }
}
