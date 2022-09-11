package backtracking.Leetcode_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer>  path = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return res;
    }

    void backtracking(int[] candidates,int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = index; i<candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(candidates, target,sum+candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
