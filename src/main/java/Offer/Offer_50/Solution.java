package Offer.Offer_50;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public char firstUniqChar(String s) {
        int[] res = new int[26];
        char ans = ' ';
        for (char c : s.toCharArray()) {
            res[c - 'a'] += 1;
        }
        for (char c : s.toCharArray()) {
            if (res[c - 'a'] == 1) {
                ans = c;
                break;
            }
        }

        return ans;
    }
/*
LinkedHashMap 为有序hash表，支持两种顺序，分别为插入顺序和访问顺序，加入参数 accessOrder = true,则按照访问顺序进行排序

 */
    public char firstUniqChar1(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsValue(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
