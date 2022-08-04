package Offer.Offer_53_I;

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || target < nums[0] || target > nums[len-1]) {
            return 0;
        }
        int i,j;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                i = mid;
                j = mid;
                while (i - 1 >= 0 && nums[i-1] == target) {
                    i--;
                }
                while (j + 1 < len && nums[j+1] == target) {
                    j++;
                }
                return j - i + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }
}
