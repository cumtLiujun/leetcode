package ArrayList;

import java.util.ArrayList;
import java.util.List;

/*
回溯算法经典题型，对于寻找所有有可能的解
 */


/*
对于数组中的数据都有两种可能，选取和跳过；
方法1:回溯且不进行剪枝，去掉无效的分支
 */
public class combinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, res, combine, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int index) {

        if (index == candidates.length) return;

        if (target == 0) {
            res.add(combine);
            return;
        }

        dfs(candidates, target, res, combine,index+1);

        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], res, combine,index);
            combine.remove(combine.size() -1);
        }

    }
}
