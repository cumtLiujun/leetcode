package slideWindows;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windows = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char x = s.charAt(right);
            right++;
            windows.put(x, windows.getOrDefault(x, 0) + 1);
            while (windows.get(x) > 1) {
                char d = s.charAt(left);
                windows.put(d, windows.get(d) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
