package backtracking.Leetcode_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder path = new StringBuilder();
        backtrack(digits,path,numString,0);
        return res;
    }

    private void backtrack(String digits, StringBuilder path, String[] numMap, int num) {
        if (num == digits.length()) {
            res.add(path.toString());
            return;
        }

        String str = numMap[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length();i++) {
            path.append(str.charAt(i));
            backtrack(digits,path,numMap,num+1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
