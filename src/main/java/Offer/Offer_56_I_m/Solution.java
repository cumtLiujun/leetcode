package Offer.Offer_56_I_m;

public class Solution {
    public int[] singleNumbers(int[] nums) {

        int m = 1, n = 0;
        int x = 0, y = 0;
        for (int num : nums) {
            n ^= num;
        }
        while ((m & n) == 0) {
            m <<= 1;
        }

        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            }
        }
        y = x ^ n;
        return new int[]{x, y};
    }
}
