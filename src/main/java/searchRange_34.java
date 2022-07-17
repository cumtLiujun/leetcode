import java.util.ArrayList;

public class searchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int index = binarySearch(nums, target);
        if (index == -1) {
            return res;
        } else {
           if (index == 0){
               res[0] = index;
               if (nums.length == 1) {
                   res[1] = index;
               } else {
                   for (int i = 1; i < nums.length; i++) {
                       if (nums[i] != target) {
                           res[1] =i-1;
                           break;
                       }
                   }
                   res[1] = res[1] == -1 ? nums.length-1 : res[1];
               }
           } else if (index == nums.length - 1) {
               for (int i = index - 1; i >= 0; i--) {
                   if (nums[i] != target) {
                       res[0] = i+1;
                       break;
                   }
               }
               res[0] = res[0] == -1 ? 0 : res[0];
               res[1] = index;
           } else {
               for (int i = index - 1; i >= 0; i--) {
                   if (nums[i] != target) {
                       res[0] = i+1;
                       break;
                   }
               }
               for (int i = index + 1; i < nums.length; i++) {
                   if (nums[i] != target) {
                       res[1] =i-1;
                       break;
                   }
               }
               res[0] = res[0] == -1 ? 0 : res[0];
               res[1] = res[1] == -1 ? nums.length - 1 : res[1];
           }
        }
        return res;

    }
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        searchRange_34 searchRange34 = new searchRange_34();
        int[] nums = {1,2,3};
        int target = 1;
        searchRange34.searchRange(nums, target);
    }
}