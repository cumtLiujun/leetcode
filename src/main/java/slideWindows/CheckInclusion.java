package slideWindows;

import java.util.HashMap;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need =  new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

//        初始化need
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }

            }
        }
        return false;
    }
}
