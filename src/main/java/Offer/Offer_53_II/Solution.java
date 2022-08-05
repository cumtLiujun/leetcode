package Offer.Offer_53_II;

public class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == mid) {
                left = mid + 1;
            }
            if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left;
    }
}
