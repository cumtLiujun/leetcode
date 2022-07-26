package Offer.Offer_39;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len <= 2) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i > len / 2 - 1) {
                if (map.get(nums[i]) > len / 2) {
                    ans = nums[i];
                    break;
                };
            }
        }
        return ans;
    }
}
