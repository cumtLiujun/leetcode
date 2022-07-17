package string;

import jdk.nashorn.internal.runtime.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams_438 {

//    暴力对比，equal 方法 遍历次数过多，时间超限
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLength = p.length();
        for (int i = 0;i < s.length() - pLength + 1; i++) {
            if (equals(s.substring(i, i + pLength), p)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean equals(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        return Arrays.equals(charA, charB);
    }

    /*
    方法2：滑动窗口
     */

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return  res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i< pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
