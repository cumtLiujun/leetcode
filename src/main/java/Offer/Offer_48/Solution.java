package Offer.Offer_48;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windows = new HashMap<>();

        int left = 0, right = 0;
        int max = 0;
        int len = s.length();

        while(right < len) {
            char in = s.charAt(right);
            right++;
            windows.put(in, windows.getOrDefault(in, 0) +1);
            while(windows.get(in) > 1) {
                char ou = s.charAt(left);
                windows.put(ou,windows.get(ou)-1);
                left++;
            }
            max = Math.max(right-left,max);
        }
        return max;
    }
}
