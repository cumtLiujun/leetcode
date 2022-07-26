package Offer.Offer_38;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> res = new LinkedList<>();
    public String[] permutation(String s) {
        StringBuffer trace = new StringBuffer();
        backtrack(s, trace);
        return res.toArray(new String[0]);
    }

    private void backtrack(String s, StringBuffer trace) {
        if (trace.length() == s.length()){
            res.add(trace.toString());
            return;
        }
        for (Character c : s.toCharArray()) {
//            粗暴判断，遇到重复数据时，会出错；
            if (trace.toString().contains(String.valueOf(c))) continue;
            trace.append(c);
            backtrack(s, trace);
            trace.delete(trace.length() -1, trace.length());
        }
    }
}
